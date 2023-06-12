
    .data
    prompt: .asciiz "Enter the time of day (in hours, 0-23): "
    day: .asciiz "Day\n"
    night: .asciiz "Night\n"
    invalid: .asciiz "Invalid input\n"

            .text
            .globl main
    main:

    li $v0, 4
    la $a0, prompt
    syscall


    li $v0, 5
    syscall
    move $t0, $v0
    blez $t0, invalid_input
    bgt $t0, 23, invalid_input


    li $t1, 6
    li $t2, 18
    blt $t0, $t1, is_night
    bge $t0, $t2, is_night
    j is_day

    is_day:

    li $v0, 4
    la $a0, day
    syscall
    j exit

    is_night:
    li $v0, 4
    la $a0, night
    syscall
    j exit

    invalid_input:
    li $v0, 4
    la $a0, invalid
    syscall

    exit:
}
