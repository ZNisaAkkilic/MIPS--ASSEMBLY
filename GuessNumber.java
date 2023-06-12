
    .data
    prompt1: .asciiz "I am thinking of a number between 1 and 100"
    prompt2: .asciiz "\nWhat is your guess (1 - 100)? :"
    output1: .asciiz "\nThe number is higher"
    output2: .asciiz "\nThe number is lower"
    output3: .asciiz "\nYou got it"
    output4: .asciiz "\nNumber of tries: "

            .text
    la $a0, prompt1
    jal PrintString

    li $a0, 10
    li $a1, 100
    li $v0, 42
    syscall
    move $s0, $a0
    addi $s0, $s0, 1

    li $s1, 0

    la $a0, prompt2
    jal PromptInt
    move $s2, $v0
    startLoop:
    addi $s1, $s1, 1

    seq $t0, $s0, $s2
    beqz $t0, greaterThan
    la $a0, output3
    jal PrintString
    la $a0, output4
    move $a1, $s1
    jal PrintInt
    b endLoop

    greaterThan:
    sgt $t0, $s0, $s2
    beqz $t0, lessThan

    la $a0, output1
    jal PrintString
    b endIf

    lessThan:
    la $a0, output2
    jal PrintString
    b endIf

    endIf:
    la $a0, prompt2
    jal PromptInt
    move $s2, $v0
    b startLoop

    endLoop:
    jal Exit


