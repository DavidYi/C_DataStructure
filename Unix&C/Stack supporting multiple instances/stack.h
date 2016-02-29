/*****************************************

  Stack.h and Stack.c implement a stack of doubles.

  A client program accesses the stack via the interface defined below.

*********************************************/ 

typedef struct stack Stack;


/************************
 * Creates a new stack instance and returns a reference to that instance.
 * 
 * It is the responsibility of the calling code to free the reference 
 * when done.
 */
Stack* createStack();


/************************
 * Push
 *
 * Pushes "d" onto the stack.
 */
void push (Stack *s, double d);


/************************
 * pop
 *
 * Pops next double off the stack.
 * Returns the double if successful.
 * Returns NAN if an error occurs.  (Stack empty).
 */
double pop (Stack *s);


/************************
 * isStackEmpty
 *
 * If the stack is empty, returns 1 (true).  
 * Otherwise, returns 0 (false). 
 */
int isStackEmpty (Stack *s);


/************************
 * isStackEmpty
 *
 * Returns the current size of the stack. 
 */
int getStackSize (Stack *s);


/************************
 * emptyStack
 *
 * Empties the stack entirely.  
 * After this call, getStackSize() should equal 0.
 */
void emptyStack (Stack *s);

