package automation;

import net.lightbody.bmp.core.har.Har;
import net.lightbody.bmp.proxy.ProxyServer;
import org.testng.annotations.Test;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class ProxyServerTest {
	
	@Test
    public void testMobProxyServer() throws Exception {
        ProxyServer server = new ProxyServer(8071);
        server.start();
 
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.PROXY, server.seleniumProxy());
 
        WebDriver driver = new FirefoxDriver(capabilities);
 
        driver.get("http://yandex.ru");
         
        driver.quit();
        server.stop();
    }

}
