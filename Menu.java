
    .data
    prompt: .asciiz "Enter 1 for burger, 2 for hot dog, 3 to calculate total: "
    result: .asciiz "Total price is: "

            .text
    main:
    li $s0, 0
    la $a0, prompt
    li $v0, 4
    syscall
    li $v0, 5
            syscall
    move $s1, $v0
    j switch

    calculate:

    li $v0, 4
    la $a0, result
    syscall
    li $v0, 1
    move $a0, $s0
    syscall
    j end

switch:
    li $t0, 1
    beq $s1, $t0, case1
    li $t0, 2
    beq $s1, $t0, case2
    li $t0, 3
    beq $s1, $t0, calculate
    j exit

    case1:
    addi $s0, $s0, 3
    la $a0, prompt
    li $v0, 4
    syscall
    li $v0, 5
            syscall
    move $s1, $v0
    j switch

    case2:
    addi $s0, $s0, 2
    la $a0, prompt
    li $v0, 4
    syscall
    li $v0, 5
            syscall
    move $s1, $v0
    j switch

    exit:
    li $v0, 10
    syscall

    end:
    li $v0, 4
    la $a0, result
    syscall
    li $v0, 1
    move $a0, $s0
    syscall
    j exit


