#include <stdio.h>
#include <ctype.h>

int main(){
  char c = getchar();
  int line = 1, ch = 0, ll = 0, lc = 0;

  while (c != EOF){
    if (c == '\n'){
      line++;
      ch = 0;
    }else{
      ch++;
    }
    if (ch > lc){
      ll = line;
      lc = ch;
    }
    c = getchar();
  }

  printf ("Line %d is the longest, with %d characters", ll, lc);  
}
