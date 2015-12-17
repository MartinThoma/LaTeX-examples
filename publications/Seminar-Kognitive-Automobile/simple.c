#include <stdio.h>

int main(void) {
    char buff[10];
    int pass = 0;

    printf("Enter password: ");
    gets(buff);

    if (strcmp(buff, "correct")) {
        printf("Wrong Password\n");
    } else {
        printf("Correct Password\n");
        pass = 1;
    }

    if (pass) {
        printf("Password protected");
        printf(" code. pass=%i\n",
               pass);
    }

    return 0;
}