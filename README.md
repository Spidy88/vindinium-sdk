vindinium-sdk
=============

An SDK for creating and running bots on vindinium.org

Create a bot in minutes.

```java
IBot bot = new RandoBot(); // Replace with your bot

Config config = new Config();
config.setKey("YOUR_BOTS_KEY");

Vindinium vindinium = new Vindinium(config);
String viewUrl = vindinium.playGame(bot);

System.out.println(String.format("View game here: %s", viewUrl));
```
