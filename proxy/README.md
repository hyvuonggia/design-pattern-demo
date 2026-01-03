# Proxy Design Pattern

## Overview
The Proxy pattern is a structural design pattern that provides a surrogate or placeholder for another object to control access to it. It acts as an intermediary that can add additional behavior before delegating to the real object, such as lazy initialization, access control, logging, or caching.

## Difficulty Level: 3/5
The Proxy pattern requires understanding the principle of delegation and the concept of interfaces. While not overly complex, distinguishing between different proxy types (protection proxy, virtual proxy, smart reference) and implementing them correctly takes some practice.

## Popularity Level: 4/5
The Proxy pattern is widely used in professional software development, particularly in enterprise applications, frameworks, and libraries. It's especially common in remote access scenarios, lazy loading, and access control implementations. Modern frameworks often use proxies for features like AOP (Aspect-Oriented Programming) and mocking in tests.

## Key Concepts

### Components
1. **Subject Interface**: The common interface that both the real object and proxy implement
2. **Real Subject**: The actual object that performs the real work
3. **Proxy**: Provides a surrogate that controls access to the real subject
4. **Client**: Works with the subject through the common interface

### How It Works
- Client requests are made to the proxy instead of the real subject
- Proxy can perform additional operations before delegating to the real subject
- Proxy and real subject implement the same interface
- Client doesn't know if it's working with the proxy or the real subject

## Benefits

### 1. **Access Control**
- Control who can access the real object and under what conditions
- Implement permission checks before delegating requests
- Enforce security policies transparently

### 2. **Lazy Initialization (Virtual Proxy)**
- Defer expensive object creation until first use
- Save memory and resources for objects that might not be used
- Improve application startup time

### 3. **Logging and Monitoring**
- Log all access to the real object
- Monitor usage patterns and performance metrics
- Track who accessed what and when

### 4. **Caching**
- Cache expensive operation results
- Reduce database or network calls
- Improve performance without modifying client code

### 5. **Remote Access**
- Proxy on client side communicates with real object on remote server
- Abstract away network communication details
- Handle serialization and marshaling transparently

### 6. **Reference Counting (Smart Reference)**
- Manage object lifetime automatically
- Free resources when last reference is released
- Prevent memory leaks

### 7. **Transparent Substitution**
- Replace real object with proxy without changing client code
- Client code doesn't need to know about proxy existence
- Easy to add proxy behavior to existing code

## When to Use the Proxy Pattern

### Use Proxy Pattern When:

1. **You Need to Control Access to an Object**
   - Different users have different permissions
   - Access should be restricted based on conditions
   - Example: Secretary controlling access to CEO, admin-only operations

2. **You Want Lazy Initialization**
   - Object creation is expensive
   - Object might not be needed at all
   - Example: Loading images, database connections, remote resources

3. **You Need to Log or Monitor Access**
   - Track who is accessing sensitive resources
   - Monitor performance and usage patterns
   - Example: Database access logging, API call tracking

4. **You Want to Cache Results**
   - Operations are expensive and frequently repeated
   - Results don't change frequently
   - Example: Web service caching, database query caching

5. **You're Working with Remote Objects**
   - Objects are on different machines
   - Need to abstract network communication
   - Example: RPC frameworks, web service clients

## Signs You Need the Proxy Pattern

### 🚩 Red Flags (Code Smells):

1. **Scattered Access Control Logic**
   ```java
   // Permission checks scattered throughout code
   if (user.hasPermission("sign_document")) {
       document.sign();
   }
   if (user.hasPermission("approve_document")) {
       document.approve();
   }
   // ... repeated everywhere
   ```

2. **Expensive Operations Called Frequently**
   - Database queries on every access
   - Network calls without caching
   - Heavy object initialization
   - Performance degradation

3. **Complex Object Creation**
   ```java
   // Client needs to manage expensive object creation
   if (heavyObject == null) {
       heavyObject = new HeavyObject(); // Expensive!
   }
   heavyObject.doSomething();
   ```

4. **Missing Logging and Monitoring**
   - No visibility into who accessed what
   - Can't track usage patterns
   - Difficult to debug issues
   - No audit trail

5. **Conditional Logic Before Real Operations**
   - Permission checks before every operation
   - Validation logic mixed with business logic
   - Difficult to change access rules

6. **Tight Coupling to Implementation Details**
   - Client depends on concrete class
   - Difficult to swap implementations
   - Hard to add cross-cutting concerns

### 🎯 When You See These Patterns:

- "We need to check permissions before allowing this operation"
- "This object is expensive to create; we should only create it when needed"
- "We need to log all access to sensitive resources"
- "We want to cache results to improve performance"
- "We need to restrict access to certain features for some users"
- "How do we handle remote communication transparently?"

## Real-World Examples

### Common Use Cases:
1. **Access Control**: Secretary controlling access to CEO, role-based permissions
2. **Lazy Loading**: Loading images only when visible, database connections on demand
3. **Caching Proxy**: Database query results, API responses, computed values
4. **Remote Proxy**: Web service clients, RPC calls, distributed systems
5. **Smart References**: Reference counting, automatic resource cleanup
6. **Logging Proxy**: Database access logs, API call tracking, audit trails
7. **Validation Proxy**: Input validation before processing, business rule enforcement
8. **Decorator-like Proxies**: Adding timestamps, encryption, compression
9. **Thread-safe Proxies**: Synchronization without modifying original class
10. **Firewall**: Network traffic filtering, IP blocking, request validation

## Implementation in This Demo

This demonstration shows the Proxy pattern applied to a document signing system with access control:

- **Subject Interface**: `Leader.java` - Defines the common interface for signing documents
- **Real Subject**: `CEO.java` - The actual executive who signs important documents
- **Proxy**: `Secretary.java` - Controls access to the CEO, signs regular documents, and forwards important ones
- **Client**: `ProxyApp.java` - Requests document signing through the secretary (proxy)

### Usage Example:
```java
// Create the real subject
CEO ceo = new CEO();

// Create the proxy
Secretary secretary = new Secretary(ceo);

// Client uses proxy instead of CEO directly
secretary.signDocument("Project_Plan.pdf");           // Secretary signs
secretary.signDocument("Financial_Report_[IMPORTANT].pdf"); // Secretary forwards to CEO
```

### Key Advantages Demonstrated:
- ✅ **Access Control**: Secretary validates document importance before CEO involvement
- ✅ **Filtering**: Secretary handles regular documents, only important ones reach CEO
- ✅ **Validation**: Secretary checks if document name is valid before processing
- ✅ **Reduced Load**: CEO only handles important documents, reducing CEO's workload
- ✅ **Transparent**: Client uses same interface regardless of who signs the document
- ✅ **Easy to Extend**: Can add logging, validation, or caching without changing CEO or client code

## Best Practices

1. **Keep Proxy Lightweight**
   - Proxy should only add control logic, not business logic
   - Avoid duplicating real subject's functionality
   - Delegate all real work to the real subject

2. **Use Composition Over Inheritance**
   - Have proxy hold a reference to real subject
   - Don't inherit from real subject
   - Allows for better flexibility

3. **Maintain the Same Interface**
   - Proxy and real subject should implement same interface
   - Client shouldn't need to know about proxy existence
   - Ensure transparent substitution

4. **Consider Thread Safety**
   - For multi-threaded environments, ensure proxy is thread-safe
   - Protect access to shared state
   - Handle concurrent access correctly

5. **Document Proxy Behavior**
   - Clearly document what the proxy does
   - Explain when real object is accessed
   - Document side effects (logging, caching, etc.)

6. **Lazy Initialize Carefully**
   - Handle initialization errors gracefully
   - Consider thread safety in lazy initialization
   - Decide when to actually create the real object

7. **Monitor Proxy Performance**
   - Proxies should not be a performance bottleneck
   - Monitor cache hit rates for caching proxies
   - Track lazy loading behavior

## Types of Proxies

### 1. **Protection Proxy** (Access Control)
- Controls access based on permissions
- Example: Secretary controlling access to CEO
- Validates requests before reaching real object

### 2. **Virtual Proxy** (Lazy Loading)
- Defers expensive object creation
- Example: Image proxy loading image only when displayed
- Improves memory usage and startup time

### 3. **Remote Proxy** (Remote Access)
- Represents object on different machine
- Example: Web service client, RPC proxy
- Handles network communication transparently

### 4. **Smart Reference (Reference Counting)**
- Manages object lifetime
- Example: Automatic resource cleanup
- Handles reference counting automatically

### 5. **Caching Proxy**
- Caches expensive operation results
- Example: Database query cache, API response cache
- Reduces repeated expensive operations

### 6. **Logging Proxy**
- Logs all access to the real object
- Example: Audit logs, usage tracking
- Records who accessed what and when

## Proxy vs. Other Patterns

### Proxy vs. Facade
- **Proxy**: One-to-one relationship with real object; controls access
- **Facade**: Multiple objects hidden; simplifies interface
- Proxy maintains same interface; Facade provides new simplified interface

### Proxy vs. Decorator
- **Proxy**: Controls access to object; client may not know about proxy
- **Decorator**: Adds functionality; wrapper is typically known
- Proxy hides itself; Decorator is typically exposed

### Proxy vs. Adapter
- **Proxy**: Same interface as real object
- **Adapter**: Converts one interface to another
- Proxy substitutes transparently; Adapter converts interfaces

## Related Patterns

- **Decorator Pattern**: Both provide alternative implementations but with different purposes
- **Facade Pattern**: Both can simplify object access but with different scope
- **Factory Pattern**: Can be used with Proxy to create lazy-loaded objects
- **Observer Pattern**: Proxy can trigger observer notifications
- **Singleton Pattern**: Proxy often implemented as singleton for global access

## Common Pitfalls

1. **Proxy Too Heavy**: Adding too much logic to proxy instead of keeping it lightweight
2. **Interface Mismatch**: Proxy interface differs from real subject interface
3. **Performance Overhead**: Proxy adds unnecessary overhead (measure and optimize)
4. **Forgetting to Delegate**: Proxy doesn't forward calls to real subject
5. **Thread Safety Issues**: Not handling concurrent access properly
6. **Memory Leaks**: Proxy holding references preventing garbage collection
7. **Excessive Caching**: Cached data becoming stale without invalidation

## Proxy Patterns in Real Systems

### Web Development
- **Reverse Proxies**: nginx/Apache proxying requests to application servers
- **API Proxies**: Wrapping external APIs, adding authentication and rate limiting
- **CDN Proxies**: Serving cached content geographically closer to users

### Enterprise Systems
- **Database Proxies**: Connection pooling, query caching, replication handling
- **Transaction Proxies**: Managing transactions across multiple services
- **Security Proxies**: Authorization checks, encryption/decryption

### Modern Frameworks
- **AOP Frameworks**: Proxies for cross-cutting concerns (logging, transactions)
- **Mock Objects**: Testing frameworks using proxies to mock dependencies
- **ORM Frameworks**: Lazy loading associations through proxies

## Conclusion

The Proxy pattern is a powerful tool for controlling access to objects and adding cross-cutting concerns transparently. It promotes:
- **Controlled Access**: Secure and validated access to resources
- **Performance**: Lazy loading, caching, and optimized resource usage
- **Transparency**: Client code doesn't change when proxy is added
- **Flexibility**: Easy to add logging, monitoring, and validation
- **Separation of Concerns**: Access control logic separated from business logic

When you need to control access to an object, defer its creation, add logging, implement caching, or handle remote communication, the Proxy pattern provides an elegant and transparent solution. It's especially valuable in enterprise systems where access control, performance optimization, and monitoring are critical.
