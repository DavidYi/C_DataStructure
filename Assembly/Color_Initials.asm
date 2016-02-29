; This program draws my initial.  The difference between this program and 
; the first is that this one uses a subroutine.
;
define ASCII_0      $30	    ; Value for ASCII 0 in hex

; System variables
define sysLastKey   $ff
define current_char $12
define current_digit $13
define bkColor $04
define textColor $03

readKeys:
	LDA sysLastKey
	CMP current_char
	
	BEQ readKeys ;loop if same key pressed
	STA current_char
	SEC
	SBC #ASCII_0
	STA current_digit
	
	JSR clearScreen
	
	LDA current_digit
	
	CMP #$01
	BEQ readKey_1
	
	CMP #$02
	BEQ readKey_2
	
	CMP #$03
	BEQ readKey_3
	
	CMP #$04
	BEQ readKey_4
	
	JMP read_keys

readKey_1:
	JSR draw1
	JMP readKeys

readKey_2:
	JSR draw2
	JMP readKeys

readKey_3:
	JSR draw3
	JMP readKeys

readKey_4:
	JSR draw4
	JMP readKeys

clearScreen:
	LDA #bkColor
	LDY #$00

innerLoop1:
	STA $0200, Y
	INY
	BNE innerLoop1

innerLoop2:
	STA $0300, Y
	INY
	BNE innerLoop2

innerLoop3:
	STA $0400, Y
	INY
	BNE innerLoop3

innerLoop4:
	STA $0500, Y
	INY
	BNE innerLoop4
	
	RTS

draw1:
	LDA #textColor
	STA $0200
	STA $0220
	STA $0240
	STA $0260
	STA $0280
	
	RTS

draw2:
	LDA #textColor
	STA $0200
	STA $0201
	STA $0202
	STA $0222
	STA $0242
	STA $0241
	STA $0240
	STA $0260
	STA $0280
	STA $0281
	STA $0282
	
	RTS

draw3:	
	LDA #textColor
	STA $0200
	STA $0201
	STA $0202
	STA $0222
	STA $0242
	STA $0241
	STA $0240
	STA $0262
	STA $0282
	STA $0281
	STA $0280
	
	RTS

draw4:
	LDA #textColor
	STA $0202
	STA $0222
	STA $0242
	STA $0262
	STA $0282
	STA	$0200
	STA	$0220
	STA $0240
	STA $0241
	
	RTS