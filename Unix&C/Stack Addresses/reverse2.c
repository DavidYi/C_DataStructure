#include <stdio.h>
#include <string.h>

void reverse (char* before, char* after){
  int i;
  int j;
  int len;

  len = strlen(before);

  for (j=len-1, i=0; j>=0; j--, i++)
    after[i] = before[j];

  after[len] = 0;
}

main(){
  char str_in[16];
  char str_out[16];
  int len;

  printf("str_in:%d\n", str_in);
  printf("str_out:%d\n", str_out);
  printf("len: %d\n", &len);
  printf("str_out[2]: %d\n", &str_out[16]);
  
  printf("Please enter a string and I will reverse it!\n");

  gets (str_in);

  len = strlen(str_in);
  
  printf("Len:%d\n", &len);
  reverse (str_in, str_out);
  printf("Original String:%s\n", str_in);
  printf("Reversed String:%s\n", str_out);
}
