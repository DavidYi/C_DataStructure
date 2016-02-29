/*****************************************

  Stack.h and Stack.c implement a stack of ints.

  A client program accesses the stack via the interface defined below.

*********************************************/ 

typedef struct stack Stack;


/************************
 * Creates a new stack instance and returns a reference to that instance.
 */
Stack* createStack();


/************************
 * Push
 *
 * Pushes "val" onto the stack.
 */
void push (Stack *s, int val);


/************************
 * pop
 *
 * Pops next integer off the stack.
 * Returns the value if successful.
 * Returns INT_MIN if an error occurs.  (Stack empty).
 */
int pop (Stack *s);


/************************
 * isStackEmpty
 *
 * If the stack is empty, returns 1 (true).  
 * Otherwise, returns 0 (false). 
 */
int isStackEmpty (Stack *s);


/************************
 * getStackSize
 *
 * Returns the current size of the stack. 
 */
int getStackSize (Stack *s);

