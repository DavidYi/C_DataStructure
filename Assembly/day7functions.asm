;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
; Constant values
;
define x 	   $02		; Input "x" parameter
define y	   $04		; Input "y" parameter

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
; Addresses
;
define ans_addr	   $01   	; Final answer will be stored at $0001. 
define temp_addr   $02		; Temporary values can be stored at $0002.
define temp_addr_2   $04    ; Temporary values can also be stored at $0004.

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
; Main Program
; -- Push x then y onto the stack
; -- Call function e
; -- The pop the result from the stack and store it in ans_addr
LDA #x
PHA 
LDA #y
PHA 
JSR e
PLA ; get result
STA ans_addr
PLA ; throw away x
BRK

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
; e(x,y) = a(d(x+1)) + d(y)
;|Rl|1
;|Rh|2
;|y |3
;|x |4
;----
e:
	;d(x+1)
	; get x, add 1, call x+1 on stack, jump to d, 
	;get x
	TSX
	TXA
	CLC
	ADC #$04 ; there are 2 return stacks then its y, then its x. To get to x, we need 4
	TAY
	LDA $0100, Y
	
	;add 1 to x
	ADC #$01
	
	PHA ;puts accumulator on top of the stack, which is 4
	;|4 |
	;|Rl|
	;|Rh|
	;|y |
	;|x |
	;----
	JSR d;4 becomes 27	
	;|27|
	;|Rl|
	;|Rh|
	;|y |
	;|x |
	;----
	
	
	;a(d(x+1))
	JSR a;we found the value of d, now we push it onto a
	;|54|1
	;|Rl|2
	;|Rh|3
	;|y |4
	;|x |
	;----
	
	;d(y)
	;get y, push on stack, call d
	;get y
	TSX
	TXA
	CLC
	ADC #$04 ;still 4 down from stack pointer
	TAY
	LDA $0100, Y ;accumulator load in 3, 3 is just an example
	
	;push on stack
	PHA
	;|3 |
	;|27|
	;|Rl|
	;|Rh|
	;|y |
	;|x |
	;----
	;call d
	JSR d
	;|22|
	;|27|
	;|Rl|
	;|Rh|
	;|y |
	;|x |
	;----
	
	;add x and y and put it one below the return values (Put the final value on the memory one before the return address)
	PLA
	;|27|
	;|Rl|
	;|Rh|
	;|y |
	;|x |
	;---- a = 22
	STA temp_addr
	;|27|
	;|Rl|
	;|Rh|
	;|y |
	;|x |
	;----
	PLA
	;|Rl|
	;|Rh|
	;|y |
	;|x |
	;---- a=27
	ADC temp_addr ; temp address = sum
	
	STA temp_addr
	
	TSX
	TXA
	CLC
	ADC #$03
	TAY
	;this makes y = where Y is, which is where we will put the answer
	
	LDA temp_addr ; a now has the final answer
	STA $0100, Y ;stores the answer one below y
	RTS ;goes back to main
	
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
; d(x) = 5x + 7  
;
d: 
	TSX
	TXA
	CLC
	ADC #$03 ;its 3 because of there is something that JSR to d, so there is 2 other  values on the stack (return address)
	TAY
	LDA $0100, Y ;y is the one that we transfered the accumulator
	
	;5 * x
	STA temp_addr ;store memory into $02
	ADC temp_addr
	ADC temp_addr
	ADC temp_addr
	ADC temp_addr ;add 4x to x = 5x
	
	;add 7
	ADC #$07
	
	STA $0100, Y
	RTS
	
	
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
; a(x) = 2x + 3
;
a:
	;
	; Load the "x" parameter from SP + 3
	TSX
	TXA
	CLC
	ADC #$03
	TAY
	LDA $0100, Y

	; Store "x" to a temp location, then add it back to the accumulator.
	; This effectively gives us 2x
	STA temp_addr
	ADC temp_addr

	; Add 3 to the accumulator, resulting in x+3
	ADC #$03

	; Store the result back on the stack and return.
	STA $0100, Y
	RTS


;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
; b(x) = a(x+2) + a(x+1)
;
b:
	;
	; Load the "x" parameter from SP + 3
	TSX
	TXA
	CLC
	ADC #$03
	TAY
	LDA $0100, Y

	; Add 1 to the accumulator to get x + 1
	; Push x+1 to the stack as an argument for "a".
	ADC #$01	
	PHA 
	JSR a

	; Leave the result of a(x+1) on the stack for later

	;
	; Load the "x" parameter from SP + 4
	; Why is it now at SP + 4?  Because we left a(x+1) on the stack!
	;
	TSX
	TXA
	CLC
	ADC #$04
	TAY
	LDA $0100, Y

		
	; Add 2 to the accumulator to get x + 2
	; Push x+2 to the stack as an argument for "a".
	ADC #$02   
	PHA 
	JSR a

	;
	; Pop a(x+2) from the stack and store it in a temp location
	;	
	PLA				
	STA temp_addr   

	;
	; Now pop a(x+1) from the stack.  Then add a(x+2) to this value.
	PLA				
	ADC temp_addr

	; Save the final value in a temp address while we calculate where to store it on the stack.
	STA temp_addr

	; The return location is SP + 3
	TSX
	TXA
	CLC
	ADC #$03
	TAY

	; Load the final value from the temp address and write it to the stack.
	LDA temp_addr
	STA $0100, Y

	RTS


;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;