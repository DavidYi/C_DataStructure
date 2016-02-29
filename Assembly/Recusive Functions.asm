;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
; Constant values
;
define n 	   $05		; Input "n" parameter, its 5 in this case

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
; Addresses
;
define ans_addr	   $01   	; Final answer will be stored at $0001. 
define temp_addr   $02		; Temporary values can be stored at $0002.

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
; Main Program
; -- Push n then y onto the stack
; -- Call function e
; -- The pop the result from the stack and store it in ans_addr
LDA #n
PHA 
JSR f
PLA ; get result
STA ans_addr
BRK

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
; F(n) = 2 * F(n-1) - 3
; F(0) = 4
; 
f: ;if(x==0) return 4 else return 2 * f(x-1) - 3
	;start of the function
	;|SP|
	;|Rl|1
	;|Rh|2
	;|x |3
	;----
	
	;2
	;|SP |
	;|Rl |1
	;|Rh |2
	;|x-1|3
	;|Rl |
	;|Rh |
	;|x  |
	;----
	
	;2
	;|SP |
	;|Rl |1
	;|Rh |2
	;|x-2|3
	;|Rl |
	;|Rh |
	;|x-1|
	;|Rl |
	;|Rh |
	;|x  |
	;----
	
	;3
	;|SP |
	;|Rl |1
	;|Rh |2
	;|x-3|3
	;|Rl |
	;|Rh |
	;|x-2|
	;|Rl |
	;|Rh |
	;|x-1|
	;|Rl |
	;|Rh |
	;|x  |
	;----
	
	;4
	;|SP |
	;|Rl |1
	;|Rh |2
	;|x-4|3
	;|Rl |
	;|Rh |
	;|x-3|
	;|Rl |
	;|Rh |
	;|x-2|
	;|Rl |
	;|Rh |
	;|x-1|
	;|Rl |
	;|Rh |
	;|x  |
	;----
	
	;5
	;|SP |
	;|Rl |1
	;|Rh |2
	;|x-5|3 <---- this is zero in this case since x=5
	;|Rl |
	;|Rh |
	;|x-4|
	;|Rl |
	;|Rh |
	;|x-3|
	;|Rl |
	;|Rh |
	;|x-2|
	;|Rl |
	;|Rh |
	;|x-1|
	;|Rl |
	;|Rh |
	;|x  |
	;----
	
	;gets the value of x
	TSX
	TXA
	CLC
	ADC #$03
	TAY
	LDA $0100, Y
	
	;compares if x (in accumulator) equals 0
	CMP #$0
	BEQ base_case ;if true then go to base_case
	
	SEC ;clears carrybit, but subtraction form
	SBC #$01 ;subtracts 1 for the n-1 part
	PHA
	;|SP |
	;|x-1|
	;|Rl |
	;|Rh |
	;|x  |
	;----
	JSR f
	
	;if x == 0, since it will be able to pass the jump
	PLA
	;5
	;|SP |
	;|Rl |
	;|Rh |
	;|x-5|
	;|Rl |
	;|Rh |
	;|x-4|
	;|Rl |
	;|Rh |
	;|x-3|
	;|Rl |
	;|Rh |
	;|x-2|
	;|Rl |
	;|Rh |
	;|x-1|
	;|Rl |
	;|Rh |
	;|x  |
	;---- a = 4
	
	;f(x)*2
	STA temp_addr
	ADC temp_addr
	;5
	;|SP |
	;|Rl |
	;|Rh |
	;|x-5|
	;|Rl |
	;|Rh |
	;|x-4|
	;|Rl |
	;|Rh |
	;|x-3|
	;|Rl |
	;|Rh |
	;|x-2|
	;|Rl |
	;|Rh |
	;|x-1|
	;|Rl |
	;|Rh |
	;|x  | a = 8
	;----
	
	
	;-3 part of 2x-3
	SEC
	SBC #$03
	STA temp_addr ; stores the value of it
	
	;gets the f(x) value
	TSX
	TXA
	CLC
	ADC #$03
	TAY
	;places it before return stacks
	LDA temp_addr
	STA #$0100, Y
	RTS
	
base_case: ;runs when x-n=0;n can be 0++
	;used to make x-n = 4 since f(0) = 4
	
	;5
	;|SP |
	;|Rl |
	;|Rh |
	;|x-5|
	;|Rl |
	;|Rh |
	;|x-4|
	;|Rl |
	;|Rh |
	;|x-3|
	;|Rl |
	;|Rh |
	;|x-2|
	;|Rl |
	;|Rh |
	;|x-1|
	;|Rl |
	;|Rh |
	;|x  |
	;----
	
	TSX
	TXA
	CLC
	ADC #$03
	TAY ;y = sp + 3
	
	LDA #$04
	STA $0100, Y
	;5
	;|SP |
	;|4  |
	;|Rl |
	;|Rh |
	;|x-5|
	;|Rl |
	;|Rh |
	;|x-4|
	;|Rl |
	;|Rh |
	;|x-3|
	;|Rl |
	;|Rh |
	;|x-2|
	;|Rl |
	;|Rh |
	;|x-1|
	;|Rl |
	;|Rh |
	;|x  | 
	;----
	
	RTS
