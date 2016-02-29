define x $02
define ans_addr $00
define temp_addr $02

main: ;calls a, puts a parameter on the stack
	LDA #x
	PHA
	JSR a ;adds 2 return stack to the overall stack
	PLA ;inverse of PHA - this is pulls instead of pushing
	STA ans_addr
	BRK
	
a: ;a(x) = 2x + 3
	TSX
	TXA
	CLC
	ADC #$03
	TAY
	LDA $0100, Y
	STA temp_addr
	ADC temp_addr ;doubles the x
	ADC #$03 ;adds three to the doubled x 
	STA $0100, Y
	RTS ;goes back to main and gets rid of the 2 return stack

b: ;b(x) = a(x+1) + a(x+2)
	TSX
	TXA
	CLC
	ADC #$03 ;the distance from stack fc, where x+1 is going to be stored, to x (stack ff) is 3 (2+1)
	TAY
	LDA $0100, Y
	
	ADC #$01 ;add one for the x+1
	PHA
	JSR a ;puts another 2 return stack on the stack
	
	TSX
	TXA
	CLC
	ADC #$04 ;the distance from stack fc, where x+2 is going to be stored, to x (stack ff) is 4; since x+1 is below the x+2 stack (2+2)
	TAY
	LDA $0100, Y
	
	ADC #$02
	PHA
	JSR a ;a(x+2)
	
	PLA ;starts adding a(x+1) + a(x+2)
	STA temp_addr
	PLA
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