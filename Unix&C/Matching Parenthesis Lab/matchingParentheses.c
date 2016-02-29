#define STACK_SIZE 100
#include <stdio.h>

char stack[STACK_SIZE];
int sp = 0;

int push (char c){
  if (sp >= STACK_SIZE)
    return -1;
  else{
    stack[sp] = c;
    sp++;
    return 0;
  }
}

int pop (){
  if (sp <= STACK_SIZE){
    sp--;
    char temp = stack[sp];
    stack[sp] = ' ';
    return temp;
  }else{
    return -1;
  } 
}

int main(){
  int i;
  char ch = ' ';
  int error = 0;
  char expect;
  char temp;
  int count = 0;
  int line = 1;
  int full = 0;
  int empty = 0;

  for (i = 0; i < STACK_SIZE; i++)
    stack[i] = ' ';

  while ((ch != EOF) && (error == 0)){
    ch = getchar();
    count++;
    if ((ch == '{') || (ch == '[') || (ch == '(')){
      error = push(ch);
      if (error == -1)
	full = 1;
    }

    else if ((ch == '}') || (ch == ']') || (ch == ')')){
      if (sp == 0){
	error = -1;
	empty = 1;
      }else{
	temp = pop();
      }

      if (temp == '{'){
	expect = '}';
      }else if (temp == '['){
	expect = ']';
      }else if (temp == '('){
	expect = ')';
      }
      
      if ((ch != expect) || (empty == 1)){
	error = -1;
      }
    }else if (ch == '\n'){
      line++;
      count = 0;
    }
  }

  if (error == 0){
    printf("Well formatted input.");
  }
  else if (error == -1){
    if (full == 1){
      printf ("Error: Stack Full!");
    }else if (empty == 1){
      printf ("Line %d, Char %d: Found %c. No matching character.", line, count, ch);
    }else if (ch != expect){
      printf ("Line %d, Char %d: Found %c, Expected %c", line, count, ch, expect);
    }	
  }
} 
