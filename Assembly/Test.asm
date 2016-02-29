;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
; Constant values
;
define x 	   	$06		; Input "x" parameter
define y	   	$04		; Input "y" parameter

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
; Addresses
;
define ans_addr	   $01   	; Final answer will be stored at $0001. 
define temp_addr   $02		; Temporary values can be stored at $0002.

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
; main
;
main:
	LDA #x
	PHA 
	LDA #y
	PHA 
	JSR r
	PLA ; get result
	STA ans_addr
	PLA ; throw away x
	BRK


;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
; q(x) = 3x + 1
;
q:
	;|SP|
	;|Rl|1
	;|Rh|2
	;|Rl|3
	;|Rh|4
	;|y |5
	;|x |6
	;----
	;get x
	TSX
	TXA
	CLC
	ADC #$03
	TAY
	LDA $0100, Y
	
	;multiply by 3
	STA temp_addr
	ADC temp_addr
	ADC temp_addr
	
	;add by 1
	ADC #$01
	
	;store in answer address
	STA $0100, Y
	;|SP|
	;|Rl|
	;|Rh|
	;|y |
	;|x |
	;----
	
	RTS
	
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
; r(x,y) = x + q(y+3)
;
r:
	;|SP|
	;|Rl|1
	;|Rh|2
	;|y |3
	;|x |4
	;----
	
	;get y
	TSX
	TXA
	CLC
	ADC #$03
	TAY
	LDA $0100, Y
	
	;add 3
	ADC #$03
	
	;push y+3 onto stack
	PHA
	;|SP |
	;|y+3|
	;|Rl |
	;|Rh |
	;|y  |
	;|x  |
	;----
	
	;push the x onto stack
	;
	
	;go to function q
	JSR q
	;|SP|
	;|Rl|1
	;|Rh|2
	;|yf|3
	;|x |4
	;----
	
	;pull y and store
	PLA
	STA temp_addr
	
	;get x
	TSX
	TXA
	CLC
	ADC #$04
	TAY
	LDA $0100, Y
	
	;add y
	CLC 
	ADC temp_addr
	STA temp_addr
	
	;push answer
	TSX
	TXA
	CLC
	ADC #$03
	TAY
	LDA temp_addr
	STA $0100, Y
	
	RTS
