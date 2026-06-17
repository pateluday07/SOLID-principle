# Open/Closed Principle (OCP)

> **Software entities should be open for extension, but closed for modification.**

You should be able to add new behavior without changing existing, working code. This example uses a notification system that can send messages through different channels (email, SMS, and so on).

## Project Structure

```
openclosed/
├── baddesign/
│   └── NotificationService.java   # Violates OCP — grows with every new channel
├── gooddesign/
│   ├── Notifier.java              # Abstraction for all notification types
│   ├── NotificationService.java   # Stable service — does not change for new channels
│   ├── EmailNotifier.java         # Concrete email implementation
│   └── SMSNotifier.java           # Concrete SMS implementation
├── OpenClosedTester.java          # Demo entry point (good design)
└── README.md
```

## Bad Design

`baddesign.NotificationService` accepts a string type and uses `if/else` branches to decide what to send:

```java
public void send(String type) {
    if (type.equals("email")) {
        // ...
    } else if (type.equals("sms")) {
        // ...
    } else if (type.equals("push")) {
        // ...
    }
}
```

**Problems:**

- Adding a new channel (e.g. push, Slack) requires editing `NotificationService`.
- Every change risks breaking existing channels.
- The class keeps growing and becomes harder to test and maintain.

## Good Design

`gooddesign` applies OCP with polymorphism:

| Component | Role |
|-----------|------|
| `Notifier` | Interface defining `send()` — the extension point |
| `EmailNotifier`, `SMSNotifier` | Concrete implementations — add new ones without touching the service |
| `NotificationService` | Depends on `Notifier`, not on specific types |

```java
public void send(Notifier notifier) {
    notifier.send();
}
```

To support a new channel, create a class that implements `Notifier` (e.g. `PushNotifier`). No changes to `NotificationService` are required.

## Running the Demo

From the project root:

```bash
javac -d out src/openclosed/gooddesign/*.java src/openclosed/OpenClosedTester.java
java -cp out openclosed.OpenClosedTester
```

**Expected output:**

```
Sending email notification...
Sending SMS notification...
```

In IntelliJ IDEA, open `OpenClosedTester.java` and run the `main` method.

## Key Takeaways

1. **Open for extension** — New notification types are added by creating new `Notifier` implementations.
2. **Closed for modification** — `NotificationService` stays unchanged when behavior is extended.
3. **Prefer abstractions** — Depend on interfaces (`Notifier`) rather than concrete types or string flags.
4. **Avoid growing conditionals** — Repeated `if/else` or `switch` on type strings is a common sign of an OCP violation.

## Try It Yourself

Add a `PushNotifier` in `gooddesign` that implements `Notifier`, then use it in `OpenClosedTester` — without modifying `NotificationService`.
