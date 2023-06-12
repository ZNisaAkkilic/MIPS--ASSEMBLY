
    .data
    grade: .word 90
    InvalidGrade: .asciiz "Invalid grade"
    Passed: .asciiz "Passed"
    Failed: .asciiz "Failed"

            .text
    lw $t0, grade
    slti $t1, $t0, 0
    sgt $t2, $t0, 100
    or $t3, $t1, $t2
    beqz $t3, passed


        la $a0, InvalidGrade    # load address of InvalidGrade to $a0
        li $v0, 4       # load 4 to $v0 (print string)
        syscall         # print the string
        b end_if        # jump to end_if

    passed:
    sge $t4, $t0, 60
    beqz $t4, failed
        la $a0, Passed
        li $v0, 4
        syscall
        b end_if

    failed:

        la $a0, Failed
        li $v0, 4
        syscall



