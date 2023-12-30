# easyCashTask

• Use MVVM architecture pattern.
• get data from APIs provided and cache data retrieved in a secure room db.
• In case of no internet connection, the app shows the cached data and works offline.
• Prevent users from taking screenshots or recording the screen while opening the app.
• Prevent MITM cyberattacks.
• Prevent common reverse engineering and app hooking techniques 


• Prevent MITM cyberattacks.
by using SSL Pinning

 by defining our trusted domain and its corresponding public key pins in the network_security_config.xml:

<?xml version="1.0" encoding="utf-8"?>
<network-security-config>
    <domain-config>
        <domain includeSubdomains="true">example.com</domain>
        <pin-set>
            <!-- Pin for the SSL/TLS certificate of example.com -->
            <pin digest="SHA-256">ReplaceWithYourPin</pin>
            <!-- Backup Pin for the SSL/TLS certificate of example.com -->
            <pin digest="SHA-256">ReplaceWithYourPin</pin>
        </pin-set>
    </domain-config>
</network-security-config>

get ReplaceWithYourPin from this website
https://www.ssllabs.com/ssltest/

![Capture](https://github.com/alimahmoud0096/easyCashTask/assets/92761756/764f5985-8a03-4108-8caf-1d12fd419de8)
![Capture2](https://github.com/alimahmoud0096/easyCashTask/assets/92761756/6f3f9cba-e433-491b-b60a-88b436373293)
