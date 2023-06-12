
      .data
    input:      .space 81
    inputSize:  .word 80
    prompt:     .asciiz "Please enter an string: "
    output:     .asciiz "\nYou typed the string:  "

    .text
    main:

    li $v0, 4
    la $a0, prompt
    syscall


    li $v0, 8
    la $a0, input
    lw $a1, inputSize
    syscall


    li $v0, 4
    la $a0, output
    syscall


    li $v0, 4
    la $a0, input
    syscall


    li $v0, 10
    syscall


