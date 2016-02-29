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
; -- Currently it is configured for testing function "g".
; -- Update this function to test other methods.
;	
; -- Push x then y onto the stack
; -- Call function g
; -- The pop the result from the stack and store it in ans_addr
LDA #x
PHA 
LDA #y
PHA 
JSR g
PLA ; get result
STA ans_addr
PLA ; throw away x
BRK


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

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
; c(x,y) = b(x) + 2 * a(y)
;
c:
	;
	; Load the "y" parameter from SP + 3
	TSX
	TXA
	CLC
	ADC #$03
	TAY
	LDA $0100, Y

	;
	; Push y on the stack as an argument for a(y).
	; Then call a.
	PHA 
	JSR a

	;
	; Leave the result on the stack.
	; Load the "y" parameter from SP + 5
	;
	TSX
	TXA
	CLC
	ADC #$05
	TAY
	LDA $0100, Y
		
	PHA ; Push x to the stack as an argument for b.

	JSR b
	
	PLA				; b(x)
	STA temp_addr   
	PLA				; a(y)
	STA temp_addr_2   
	ADC temp_addr_2
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

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
; d(x) = 5x + 7  
;
d: 
	;
	; Load the "x" parameter from SP + 3
	TSX
	TXA
	CLC
	ADC #$03
	TAY
	LDA $0100, Y

	; Store "x" to temp address, then add it back to the accumulator 4 times.
	; This gives us 5x. 	
	STA temp_addr
	ADC temp_addr
	ADC temp_addr
	ADC temp_addr
	ADC temp_addr

	; Add 7 to the result, which now gives us 5x + 7	
	CLC
	ADC #$07

	; Store the result back at SP + 3 and return
	STA $0100, Y
	RTS

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
; e(x,y) = a(d(x+1)) + d(y)
; 
e: 
	;
	; Load the "y" parameter from SP + 3
	TSX
	TXA
	CLC
	ADC #$03
	TAY
	LDA $0100, y     

	; Push "y" onto the top of the stack as a parameter for function "d"
	; Jump to function "d"
	PHA				 
	JSR d            

    ; Leave  d(y) on the stack when the method returns.  We will get it later.
    ; Now get the "x" parameter from SP + 5
    ; What + 5? Because we left the last result on the stack
    TSX
	TXA
	CLC
	ADC #$05
	TAY
	LDA $0100, y     ; loads the y value into the accumulator
   
    ; Add 1 to x to get x + 1
    ; Push the parameter onto the stack.
    ; Call function "d"
    CLC
	ADC #$01         
	PHA
	JSR d

	; d(x+1) is now on the top of the stack.
	; Therefore, call "a" immediately.  
	; The parameter it needs is on the top of the stack already.
	JSR a

	; Get a(d(x+1)) off the stack and store it in a temp location in memory.
	PLA
	STA temp_addr

	; Get d(y) off the stack.  We left it there before!
	PLA

	; Add the temp_addr to the accumulator to get our result.
	; Save the result back to temp_addr
	ADC temp_addr
	STA temp_addr

	; Update SP + 3 with this return value.	
	TSX
	TXA
	CLC
	ADC #$03
	TAY

	; Load the return value back from temp addr and write it into the stack.
	LDA temp_addr
	STA $0100, Y
	RTS

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
; F(n) = 2 * F(n-1) - 3
; F(0) = 4
; 
f: 
	;
	; Load the "n" parameter from SP + 3
	TSX
	TXA
	CLC
	ADC #$03
	TAY
	LDA $0100, Y

	;
	; Check if n=0.  If so, then implement the base case of our recursion.
	;
	CMP #0
	BEQ base_case

	;
	; If acc > 0, 
	; then subtract 1 from n and make the recursive call.
	SEC
	SBC #$01
	PHA 
	JSR f

	;
	; Pull the result of the subroutine call.  This is the result of f(n-1)
	PLA 
	
	; Double the accumulator  (2 * F(n-1))
	STA temp_addr
	ADC	temp_addr

	; Subtract the 3 from the accumulator to complete the calculation
	SEC
	SBC #$03
	JMP merged_code

base_case:
	; If n=0.... F(0) = 4
	LDA #$04

merged_code:
	; Store the return value in the temp_addr for safe keeping while
	; we calculate the return address.
	STA temp_addr

	;
	; Calculate the address for the return value.
	;
	TSX
	TXA
	CLC
	ADC #$03
	TAY

	;
	; Reload the return value from temp_addr and then write it into the stack
	;
	LDA temp_addr
	STA $0100, Y

	RTS

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
; g(x,y) = a(b(y+5)) + d(x+2)
; 
g:
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
	
	;add 5
	CLC
	ADC #$05
	PHA
	;|SP |
	;|y+5|
	;|Rl |
	;|Rh |
	;|y  |
	;|x  |
	;-----
	
	;go through function b
	JSR b
	;|SP|
	;|y1|;finished the first function
	;|Rl|
	;|Rh|
	;|y |
	;|x |
	;----
	
	;go through function a
	JSR a
	
	;store final y in temp_addr
	PLA
	STA temp_addr2
	;|SP|
	;|Rl|1
	;|Rh|2
	;|y |3
	;|x |4
	;----
	
	;get x
	TSX
	TXA
	CLC
	ADC #$04
	TAY
	LDA $0100, Y
	;add 2
	CLC
	ADC #$02
	PHA
	;|SP |
	;|x+2|
	;|Rl |
	;|Rh |
	;|y  |
	;|x  |
	;-----
	
	;go through function d
	JSR d
	;|SP|
	;|xf|;x final
	;|Rl|
	;|Rh|
	;|y |
	;|x |
	;----
	
	;add xf and yf
	PLA
	ADC temp_addr2
	
	;put the final value in the stack before the return values
	STA temp_addr2
	TSX
	TXA
	CLC
	ADC #$03
	TAY
	LDA temp_addr2
	STA $0100, Y
	
	RTS
	