define x 	   $02
define y	   $04
define ans_addr	   $00
define temp_addr   $02
define temp_addr_2   $04

main:
	LDA #x
	PHA 
	LDA #y
	PHA 
	JSR c
	PLA ; get result
	STA ans_addr
	PLA ; throw away x
	BRK

;
;
; c(x,y) = b(x) + 2 * a(y)
;
c:
	;|SP|
	;|Rl|
	;|Rh|
	;|y |
	;|x |
	;----
	;get x
	TSX
	TXA
	;call x on stack
	CLC
	ADC #$04
	TAY
	LDA $0100, Y
	
	
	PHA ;assume x = 3
	;|SP|
	;|3 |
	;|Rl|
	;|Rh|
	;|y |
	;|x |
	;----
	
	;jump to b
	JSR b
	;|SP|
	;|24|
	;|Rl|
	;|Rh|
	;|y |
	;|x |
	;----
	
	;get y
	TSX
	TXA
	CLC
	;call y on stack
	ADC #$04
	TAY
	LDA $0100, Y
	
	PHA ;assume y = 4
	;|SP|
	;|4 |
	;|24|
	;|Rl|
	;|Rh|
	;|y |
	;|x |
	;----
	
	;jump to a
	JSR A
	;|SP|
	;|11|
	;|24|
	;|Rl|
	;|Rh|
	;|y |
	;|x |
	;----
	
	
	;multiply a(y) by 2
	PLA
	;|SP|
	;|24|
	;|Rl|
	;|Rh|
	;|y |
	;|x |
	;---- a=11
	STA temp_addr
	LDA temp_addr
	ADC temp_addr
	STA temp_addr
	
	;add b(x)
	PLA
	;|SP|
	;|Rl|
	;|Rh|
	;|y |
	;|x |
	;---- a=24
	ADC temp_addr ;finds the final answer
	STA temp_addr ;stores final answer
	
	;store final answer
	TSX
	TXA
	CLC
	ADC #$03
	TAY
	LDA temp_addr
	STA $0100,Y
	
	RTS
	

;
;
; a(x) = 2x + 3
;
a:
	TSX
	TXA
	CLC
	ADC #$03
	TAY
	LDA $0100, Y
	STA temp_addr
	ADC temp_addr
	ADC #$03
	STA $0100, Y ;store it in the stack
	;|SP|
	;|Rl|
	;|Rh|
	;|46|
	;|x |
	;---- a=24
	
	RTS

;
;
; b(x) = a(x+2) + a(x+1)
;
b:
	TSX
	TXA
	CLC
	ADC #$03
	TAY
	LDA $0100, Y

	ADC #$01	
	PHA ; Push x+1 to the stack as an argument for f.
	JSR a

	TSX
	TXA
	CLC
	ADC #$04
	TAY
	LDA $0100, Y
		
	ADC #$02   ; x + 2
	PHA ; Push x+2 to the stack as an argument for a.

	JSR a
	
	PLA				; a(x + 2)
	STA temp_addr   
	PLA				; a(x + 1)
	ADC temp_addr
	STA temp_addr

	TSX
	TXA
	CLC
	ADC #$03
	TAY

	LDA temp_addr
	STA $0100, Y

	RTS


