# Strategy Design Pattern

## Overview
The Strategy pattern is a behavioral design pattern that defines a family of algorithms, encapsulates each one, and makes them interchangeable. Strategy lets the algorithm vary independently from clients that use it.

## Difficulty Level: 2/5
The Strategy pattern is relatively easy to understand and implement. It's one of the simpler behavioral patterns, making it a great starting point for learning design patterns.

## Popularity Level: 5/5
The Strategy pattern is one of the most widely used design patterns in software development. It's commonly found in frameworks, libraries, and enterprise applications due to its flexibility and adherence to SOLID principles.

## Key Concepts

### Components
1. **Strategy Interface**: Declares an interface common to all supported algorithms
2. **Concrete Strategies**: Implement different variations of the algorithm
3. **Context**: Maintains a reference to a Strategy object and delegates algorithm execution to it
4. **Factory (Optional)**: Creates strategy objects based on input parameters, simplifying client code

### How It Works
- The client chooses which strategy to use at runtime
- The context doesn't know the specifics of how each strategy implements the algorithm
- Strategies can be swapped dynamically without changing the context

## Benefits

### 1. **Open/Closed Principle**
- Open for extension (add new strategies) without modifying existing code
- Closed for modification (existing strategies remain unchanged)

### 2. **Single Responsibility Principle**
- Each strategy class has one reason to change
- Algorithm implementations are isolated from the code that uses them

### 3. **Flexibility and Reusability**
- Strategies can be reused across different contexts
- Easy to add new algorithms without affecting existing code

### 4. **Eliminates Conditional Statements**
- Replaces large if-else or switch-case blocks with polymorphism
- Makes code cleaner and more maintainable

### 5. **Runtime Algorithm Selection**
- Choose algorithms dynamically based on runtime conditions
- Different strategies for different scenarios (e.g., different payment methods)

### 6. **Testability**
- Each strategy can be tested independently
- Easy to mock strategies for unit testing

### 7. **Encapsulation**
- Implementation details of algorithms are hidden from clients
- Reduces coupling between algorithm implementation and business logic

## When to Use the Strategy Pattern

### Use Strategy Pattern When:

1. **Multiple Related Classes Differ Only in Behavior**
   - You have several classes that differ only in how they perform a specific operation
   - Example: Different sorting algorithms, compression algorithms, payment methods

2. **You Need Different Variants of an Algorithm**
   - You need to use different variants of an algorithm
   - You want to switch between algorithms at runtime

3. **You Have Large Conditional Statements**
   - Your code contains complex if-else or switch statements that select different behaviors
   - These conditionals make the code hard to maintain and extend

4. **You Want to Isolate Algorithm Details**
   - Algorithm implementation details should be hidden from client code
   - You want to separate algorithm logic from business logic

5. **You Need to Swap Implementations at Runtime**
   - Different behaviors need to be selected dynamically based on user input or system state
   - Configuration-driven behavior selection

## Signs You Need the Strategy Pattern

### 🚩 Red Flags (Code Smells):

1. **Bloated Conditional Logic**
   ```java
   if (paymentType.equals("cash")) {
       // cash payment logic
   } else if (paymentType.equals("credit")) {
       // credit card logic
   } else if (paymentType.equals("paypal")) {
       // PayPal logic
   }
   ```

2. **Duplicate Code Across Similar Classes**
   - Multiple classes with similar structure but different algorithms
   - Repeated pattern of behavior selection

3. **Difficulty Adding New Behaviors**
   - Adding a new algorithm requires modifying existing classes
   - Changes ripple through multiple parts of the codebase

4. **God Objects or Classes with Too Many Responsibilities**
   - A single class handling multiple algorithms
   - Violation of Single Responsibility Principle

5. **Hard-to-Test Code**
   - Cannot test individual algorithms in isolation
   - Difficult to mock or stub specific behaviors

6. **Frequent Changes to Algorithm Selection Logic**
   - Business requirements frequently add new algorithm variants
   - Different clients need different algorithm implementations

### 🎯 When You See These Patterns:

- "We need to add another way to calculate/process/handle X"
- "The behavior should change based on user selection/configuration"
- "We have three different implementations of the same operation"
- "This switch statement keeps growing every sprint"

## Real-World Examples

### Common Use Cases:
1. **Payment Processing**: Cash, Credit Card, PayPal, Cryptocurrency
2. **Compression Algorithms**: ZIP, RAR, GZIP, 7-Zip
3. **Sorting Algorithms**: QuickSort, MergeSort, BubbleSort
4. **Validation Strategies**: Email validation, Phone validation, Credit card validation
5. **Routing Algorithms**: Shortest path, Fastest route, Scenic route
6. **Pricing Strategies**: Regular price, Discount, Black Friday sale
7. **Authentication Methods**: OAuth, LDAP, Basic Auth, JWT

## Implementation in This Demo

This demonstration shows the Strategy pattern applied to a payment processing system:

- **Strategy Interface**: `Payment.java` - Defines the common interface for all payment methods
- **Concrete Strategies**: 
  - `CashPayment.java` - Handles cash transactions
  - `CreditCardPayment.java` - Processes credit card payments
  - `PaypalPayment.java` - Manages PayPal transactions
- **Context**: `Order.java` - Uses a payment strategy to process orders
- **Factory**: `PaymentFactory.java` - Creates payment method instances based on string input

### Usage Example:
```java
// Create payment method using factory
Payment payment = PaymentFactory.createPaymentMethod("creditcard");
order.setPaymentMethod(payment);
order.processOrder();

// Switch to different payment method
Payment cashPayment = PaymentFactory.createPaymentMethod("cash");
order.setPaymentMethod(cashPayment);
order.processOrder();
```

### Key Advantages Demonstrated:
- ✅ Easy to add new payment methods without modifying existing code
- ✅ Clean separation of payment logic from order processing
- ✅ Each payment method can be tested independently
- ✅ Runtime selection of payment strategy
- ✅ Factory simplifies strategy object creation and eliminates direct dependencies

## Best Practices

1. **Keep Strategies Stateless When Possible**
   - Makes them easier to reuse and share

2. **Use Dependency Injection**
   - Inject strategies rather than creating them internally

3. **Consider Strategy Factory** ✅ *Implemented in this demo*
   - For complex strategy selection logic, use a factory pattern
   - Centralizes strategy creation and reduces client code complexity
   - Makes it easy to add new strategies without changing client code

4. **Document When to Use Each Strategy**
   - Make it clear when each strategy is appropriate

5. **Avoid Over-Engineering**
   - Don't use Strategy pattern for simple one-time operations

## Related Patterns

- **State Pattern**: Similar structure but focuses on state transitions
- **Template Method**: Defines algorithm skeleton; Strategy defines entire algorithm
- **Factory Pattern**: Often used together to create strategy objects
- **Decorator Pattern**: Can be combined for flexible behavior composition

## Conclusion

The Strategy pattern is a powerful tool for managing algorithmic variations in your code. It promotes clean, maintainable, and extensible software by:
- Eliminating complex conditionals
- Following SOLID principles
- Enabling runtime flexibility
- Improving testability

When you see repetitive conditional logic or need to support multiple variants of an algorithm, the Strategy pattern is likely your solution.
