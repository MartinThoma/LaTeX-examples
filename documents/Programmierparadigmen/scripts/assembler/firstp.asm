 org 100h
 start:
   mov ax, 5522h
   mov cx, 1234h
   xchg cx,ax 
   mov al, 0
   mov ah,4Ch
   int 21h