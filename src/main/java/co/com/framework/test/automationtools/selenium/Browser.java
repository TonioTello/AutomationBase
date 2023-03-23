package co.com.framework.test.automationtools.selenium;

import org.openqa.selenium.Platform;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;




import java.awt.*;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.List;

public class Browser {
    private static final String TEXT_IGNORE_ALERTS = "Ignore Alerts";
    private static final String TEXT_START_MAXIMIZED = "Start Maximized";
    private static final String MSG_ERROR_NO_SUPP = "'%s' is an unsupported driver operation in any versiÃ³n of %s driver. ";
    private Browser.Browsers browserName;
    private Browser.OS currentOS;
    private Path downloadPath;
    private boolean isUsingBrowserOptions;
    private boolean isIncognito;
    private boolean isMaximized;
    private boolean isHeadless;
    private boolean ignoreAlerts;
    private boolean autoDriverDownload;
    private boolean isRemote;
    private boolean isRemoteVNCEnabled;
    private boolean isRemoteVideoEnabled;
    private boolean isUsingBrowserName;
    private Proxy proxy; // Todo
    private Platform currentPlatform; // Todo
    private String hubURL;
    private String driverVersion;
    private Path driverFolder;
    private static EnumMap<OS, String> chromeMap;
    private static EnumMap<Browser.OS, String> firefoxMap;
    private static EnumMap<Browser.OS, String> edgeMap;
    private static EnumMap<Browser.OS, String> IEMap;
    private static final String NOT_IMPLEMENTED = "notImplemented";
    private List<String> argumentsList;
    private List<File> extensionsList;
    private Map<String, Object> chromePrefs;
    //private FirefoxProfile firefoxPrefs;
    private ChromeOptions chromeOptions;
    //private FirefoxOptions firefoxOptions;
    // InternetExplorerOptions internetExplorerOptions;
    // EdgeOptions edgeOptions;

    public Browser() {
        this.browserName = Browser.Browsers.CHROME;
        this.currentOS = Browser.OS.UNKNOWN;
        this.isUsingBrowserOptions = true;
        this.isIncognito = false;
        this.isMaximized = false;
        this.isHeadless = false;
        this.ignoreAlerts = false;
        this.autoDriverDownload = true;
        this.isRemote = false;
        this.isRemoteVNCEnabled = false;
        this.isRemoteVideoEnabled = false;
        this.isUsingBrowserName = false;
        this.proxy = null;
        this.currentPlatform = Platform.WIN10;
        this.hubURL = "http://localhost:4444/wd/hub";
        this.driverVersion = "";
        this.driverFolder = Paths.get(System.getProperty("user.dir"), "src/main/resources/drivers");
        this.argumentsList = new ArrayList();
        this.extensionsList = new ArrayList();
        this.chromePrefs = new HashMap();
        //this.firefoxPrefs = new FirefoxProfile();
        this.chromeOptions = new ChromeOptions();
        //this.firefoxOptions = new FirefoxOptions();
        //this.internetExplorerOptions = new InternetExplorerOptions();
        //this.edgeOptions = new EdgeOptions();
        //this.checkCurrentOS();
    }

/*
    public void checkCurrentOS() {
        if (SystemUtils.IS_OS_WINDOWS) {
            this.currentOS = Browser.OS.WINDOWS;
        } else if (SystemUtils.IS_OS_LINUX) {
            this.currentOS = Browser.OS.LINUX;
        } else if (SystemUtils.IS_OS_MAC) {
            this.currentOS = Browser.OS.MAC;
        } else {
            this.currentOS = Browser.OS.UNKNOWN;
        }

    }
*/

    public Browser.Browsers getBrowser() {
        return this.browserName;
    }

    public Browser.OS getCurrentOS() {
        return this.currentOS;
    }

    public List<String> getArgumentsList() {
        return this.argumentsList;
    }

    public List<File> getExtensionsList() {
        return this.extensionsList;
    }

    public String getDriverVersion() {
        return this.driverVersion;
    }

    public Path getDriverFolder() {
        return this.driverFolder;
    }

    public void setArgumentsList(List<String> argumentsList) {
        this.argumentsList = argumentsList;
    }

    public void setChromePrefs(Map<String, Object> chromePrefs) {
        this.chromePrefs = chromePrefs;
    }

/*    public void setFirefoxPrefs(FirefoxProfile firefoxPrefs) {
        this.firefoxPrefs = firefoxPrefs;
    }*/

    public void setBrowser(Browser.Browsers browser) {
        this.browserName = browser;
    }

    public void setDownloadPath(Path downloadPath) {
        this.downloadPath = downloadPath;
    }

    public Path getDownloadPath() {
        return this.downloadPath;
    }

    public void setIncognito(boolean incognito) {
        this.isIncognito = incognito;
    }

    public void setMaximized(boolean maximized) {
        this.isMaximized = maximized;
    }

    public void setHeadless(boolean headless) {
        this.isHeadless = headless;
    }

    public void setIgnoreAlerts(boolean ignoreAlerts) {
        this.ignoreAlerts = ignoreAlerts;
    }

    public void setAutoDriverDownload(boolean autoDriverDownload) {
        this.autoDriverDownload = autoDriverDownload;
    }

    public void setDriverVersion(String driverVersion) {
        this.driverVersion = driverVersion;
    }

    public void setDriverFolder(Path driverFolder) {
        this.driverFolder = driverFolder;
    }

    public boolean getIsRemote() {
        return this.isRemote;
    }

    public void setIsRemote(boolean remote) {
        this.isRemote = remote;
    }

    public String getHubURL() {
        return this.hubURL;
    }

    public void setHubURL(String hubURL) {
        this.hubURL = hubURL;
    }

    public ChromeOptions getChromeOptions() {
        return this.chromeOptions;
    }

    public void setChromeOptions(ChromeOptions chromeOptions) {
        this.chromeOptions = chromeOptions;
    }

/*
    public FirefoxOptions getFirefoxOptions() {
        return this.firefoxOptions;
    }
*/

/*
    public void setFirefoxOptions(FirefoxOptions firefoxOptions) {
        this.firefoxOptions = firefoxOptions;
    }
*/

   /* public InternetExplorerOptions getInternetExplorerOptions() {
        return this.internetExplorerOptions;
    }*/

/*    public void setInternetExplorerOptions(InternetExplorerOptions internetExplorerOptions) {
        this.internetExplorerOptions = internetExplorerOptions;
    }*/

/*
    public EdgeOptions getEdgeOptions() {
        return this.edgeOptions;
    }
*/

/*
    public void setEdgeOptions(EdgeOptions edgeOptions) {
        this.edgeOptions = edgeOptions;
    }
*/

    public boolean isRemoteVNCEnabled() {
        return this.isRemoteVNCEnabled;
    }

    public void setRemoteVNCEnabled(boolean remoteVNCEnabled) {
        this.isRemoteVNCEnabled = remoteVNCEnabled;
    }

    public boolean isRemoteVideoEnabled() {
        return this.isRemoteVideoEnabled;
    }

    public void setRemoteVideoEnabled(boolean remoteVideoEnabled) {
        this.isRemoteVideoEnabled = remoteVideoEnabled;
    }

    public Platform getOS() {
        return this.currentPlatform;
    }

    public void setCurrentPlatform(Platform currentPlatform) {
        this.currentPlatform = currentPlatform;
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    public void setProxy(Proxy proxy) {
        this.proxy = proxy;
    }

    public boolean getIsUsingBrowserName() {
        return this.isUsingBrowserName;
    }

    public void setIsUsingBrowserName(boolean usingBrowserName) {
        this.isUsingBrowserName = usingBrowserName;
    }

    public boolean isUsingBrowserOptions() {
        return this.isUsingBrowserOptions;
    }

    public void setUsingBrowserOptions(boolean usingBrowserOptions) {
        this.isUsingBrowserOptions = usingBrowserOptions;
    }

    public WebDriver createDriver() {
        this.applyBrowser(this.isUsingBrowserName);
        this.applyDownloadDirectory(this.downloadPath.toString());
        this.applyIncognito(this.isIncognito);
        this.applyMaximized(this.isMaximized);
        this.applyHeadless(this.isHeadless);
        this.applyVideo(this.isRemoteVideoEnabled);
        this.applyVNC(this.isRemoteVNCEnabled);
        this.applyProxy(this.proxy);

        try {
            this.applyIgnoreAlerts(this.ignoreAlerts);
        } catch (Exception var3) {
            String error = String.format("'%s' is an unsupported driver operation in any versiÃ³n of %s driver. ", "Ignore Alerts", "this");
            //Log.LOGGER.error(error + var3.getMessage());
        }

        switch(this.browserName) {
            case FIREFOX:
                //return this.createFireFoxDriver();
            case EDGE:
               // return this.createEdgeDriver();
            case INTERNET_EXPLORER:
               // return this.createIEDriver();
            case CHROME:
            default:
                return this.createChromeDriver();
        }
    }

    private WebDriver createChromeDriver() {
        this.chromeOptions = this.addChromeOptions();
        if (this.autoDriverDownload) {
            //WebDriverManager.chromedriver().version(this.driverVersion).setup();
        } else {
            System.setProperty("webdriver.chrome.driver", this.driverFolder.resolve(this.browserName.getValue(this.getCurrentOS())).toString());
        }

        if (this.isRemote) {
            try {
                return new RemoteWebDriver(new URL(this.hubURL), this.chromeOptions);
            } catch (MalformedURLException var2) {
                return new ChromeDriver(this.chromeOptions);
            }
        } else {
            return new ChromeDriver(this.chromeOptions);
        }
    }

    private void applyBrowser(boolean isUsingBrowserName) {
        if (isUsingBrowserName) {
            switch(this.browserName) {
                case FIREFOX:
                   // this.firefoxOptions.setCapability("browserName", "firefox");
                    break;
                case EDGE:
                    //this.edgeOptions.setCapability("browserName", "MicrosoftEdge");
                    break;
                case INTERNET_EXPLORER:
                   // this.internetExplorerOptions.setCapability("browserName", "internet explorer");
                    break;
                case CHROME:
                    this.chromeOptions.setCapability("browserName", "chrome");
            }
        }

    }

    private void applyProxy(Proxy proxy) {
        if (proxy != null) {
            switch(this.browserName) {
                case FIREFOX:
                    //this.firefoxOptions.setCapability("proxy", proxy);
                    break;
                case EDGE:
                    //this.edgeOptions.setCapability("proxy", proxy);
                    break;
                case INTERNET_EXPLORER:
                    //this.internetExplorerOptions.setCapability("proxy", proxy);
                    break;
                case CHROME:
                    this.chromeOptions.setCapability("proxy", proxy);
            }
        }

    }

/*
    private WebDriver createFireFoxDriver() {
        this.firefoxOptions = this.addFirefoxOptions();
        if (this.autoDriverDownload) {
            WebDriverManager.firefoxdriver().version(this.driverVersion).setup();
        } else {
            System.setProperty("webdriver.gecko.driver", this.driverFolder.resolve(this.browserName.getValue(this.getCurrentOS())).toString());
        }

        if (this.isRemote) {
            try {
                return new RemoteWebDriver(new URL(this.hubURL), this.firefoxOptions);
            } catch (MalformedURLException var2) {
                return new FirefoxDriver(this.firefoxOptions);
            }
        } else {
            return new FirefoxDriver(this.firefoxOptions);
        }
    }
*/

/*
    private WebDriver createEdgeDriver() {
        this.edgeOptions = new EdgeOptions();
        if (this.autoDriverDownload) {
            WebDriverManager.edgedriver().version(this.driverVersion).setup();
        } else {
            System.setProperty("webdriver.edge.driver", this.driverFolder.resolve(this.browserName.getValue(this.getCurrentOS())).toString());
        }

        if (this.isRemote) {
            try {
                return new RemoteWebDriver(new URL(this.hubURL), this.edgeOptions);
            } catch (MalformedURLException var2) {
                return new EdgeDriver(this.edgeOptions);
            }
        } else {
            return new EdgeDriver(this.edgeOptions);
        }
    }
*/

/*
    private WebDriver createIEDriver() {
        if (this.autoDriverDownload) {
            WebDriverManager.iedriver().version(this.driverVersion).setup();
        } else {
            System.setProperty("webdriver.ie.driver", this.driverFolder.resolve(this.browserName.getValue(this.getCurrentOS())).toString());
        }

        if (this.isRemote) {
            try {
                return new RemoteWebDriver(new URL(this.hubURL), this.internetExplorerOptions);
            } catch (MalformedURLException var2) {
                return new InternetExplorerDriver(this.internetExplorerOptions);
            }
        } else {
            return new InternetExplorerDriver(this.internetExplorerOptions);
        }
    }
*/

    private ChromeOptions addChromeOptions() {
        String[] listaArgumentos = (String[])this.argumentsList.toArray(new String[0]);
        this.chromeOptions.addExtensions(this.extensionsList);
        this.chromeOptions.setExperimentalOption("prefs", this.chromePrefs);
        this.chromeOptions.addArguments(listaArgumentos);
        return this.chromeOptions;
    }

/*
    private FirefoxOptions addFirefoxOptions() {
        String[] listaArgumentos = (String[])this.argumentsList.toArray(new String[0]);
        this.firefoxOptions.addArguments(listaArgumentos);
        this.firefoxOptions.setProfile(this.firefoxPrefs);
        return this.firefoxOptions;
    }
*/

    private void applyDownloadDirectory(String downloadPath) {
        if (!downloadPath.isEmpty()) {
            String downloadDirectory = (new File(downloadPath)).getAbsolutePath();
            String error;
            switch(this.browserName) {
                case FIREFOX:
//                    this.firefoxPrefs.setPreference("browser.download.dir", downloadDirectory);
//                    this.firefoxPrefs.setPreference("browser.download.folderList", 2);
//                    this.firefoxPrefs.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;");
//                    this.firefoxPrefs.setPreference("browser.download.manager.showWhenStarting", false);
//                    this.firefoxPrefs.setPreference("pdfjs.disabled", true);
                    break;
                case EDGE:
                    error = String.format("'%s' is an unsupported driver operation in any versiÃ³n of %s driver. ", "Download path change", Browser.Browsers.EDGE);
                    //Log.LOGGER.error(error);
                    break;
                case INTERNET_EXPLORER:
                    error = String.format("'%s' is an unsupported driver operation in any versiÃ³n of %s driver. ", "Download path change", Browser.Browsers.INTERNET_EXPLORER);
                    //Log.LOGGER.error(error);
                    break;
                case CHROME:
                    this.chromePrefs.put("download.default_directory", downloadDirectory);
                    this.argumentsList.add("--test-type");
            }
        }

    }

    private void applyIncognito(boolean isIncognito) {
        if (isIncognito) {
            switch(this.browserName) {
                case FIREFOX:
                    //this.firefoxPrefs.setPreference("browser.private.browsing.autostart", true);
                    break;
                case EDGE:
                    String error = String.format("'%s' is an unsupported driver operation in any versiÃ³n of %s driver. ", "In private", Browser.Browsers.EDGE);
                    //Log.LOGGER.error(error);
                    break;
                case INTERNET_EXPLORER:
                    //this.internetExplorerOptions.setCapability("ie.browserCommandLineSwitches", "-private");
                    break;
                case CHROME:
                    this.argumentsList.add("--incognito");
            }
        }

    }

    private void applyVNC(boolean isVNCEnabled) {
        if (isVNCEnabled) {
            String error;
            switch(this.browserName) {
                case FIREFOX:
                    //this.firefoxOptions.setCapability("enableVNC", true);
                    break;
                case EDGE:
                    error = String.format("'%s' is an unsupported driver operation in any versiÃ³n of %s driver. ", "VNC for remote", Browser.Browsers.EDGE);
                    //Log.LOGGER.error(error);
                    break;
                case INTERNET_EXPLORER:
                    error = String.format("'%s' is an unsupported driver operation in any versiÃ³n of %s driver. ", "VNC for remote", Browser.Browsers.INTERNET_EXPLORER);
                    //Log.LOGGER.error(error);
                    break;
                case CHROME:
                    this.chromeOptions.setCapability("enableVNC", true);
            }
        }

    }

    private void applyVideo(boolean isVideoEnabled) {
        if (isVideoEnabled) {
            String error;
            switch(this.browserName) {
                case FIREFOX:
                    //this.firefoxOptions.setCapability("enableVideo", false);
                    break;
                case EDGE:
                    error = String.format("'%s' is an unsupported driver operation in any versiÃ³n of %s driver. ", "Video for remote", Browser.Browsers.EDGE);
                    //Log.LOGGER.error(error);
                    break;
                case INTERNET_EXPLORER:
                    error = String.format("'%s' is an unsupported driver operation in any versiÃ³n of %s driver. ", "Video for remote", Browser.Browsers.INTERNET_EXPLORER);
                    //Log.LOGGER.error(error);
                    break;
                case CHROME:
                    this.chromeOptions.setCapability("enableVideo", false);
            }
        }

    }

    private void applyMaximized(boolean isMaximized) {
        if (isMaximized) {
            String error;
            switch(this.browserName) {
                case FIREFOX:
                    error = String.format("'%s' is an unsupported driver operation in any versiÃ³n of %s driver. ", "Start Maximized", Browser.Browsers.FIREFOX);
                    //Log.LOGGER.error(error);
                    break;
                case EDGE:
                    error = String.format("'%s' is an unsupported driver operation in any versiÃ³n of %s driver. ", "Start Maximized", Browser.Browsers.EDGE);
                    //Log.LOGGER.error(error);
                    break;
                case INTERNET_EXPLORER:
                    error = String.format("'%s' is an unsupported driver operation in any versiÃ³n of %s driver. ", "Start Maximized", Browser.Browsers.INTERNET_EXPLORER);
                    //Log.LOGGER.error(error);
                    break;
                case CHROME:
                    this.argumentsList.add("--start-maximized");
            }
        }

    }

    private void applyHeadless(boolean isHeadless) {
        if (isHeadless) {
            String error;
            switch(this.browserName) {
                case FIREFOX:
                    this.argumentsList.add("-headless");
                    break;
                case EDGE:
                    error = String.format("'%s' is an unsupported driver operation in any versiÃ³n of %s driver. ", "Headless", Browser.Browsers.EDGE);
                    //Log.LOGGER.error(error);
                    break;
                case INTERNET_EXPLORER:
                    error = String.format("'%s' is an unsupported driver operation in any versiÃ³n of %s driver. ", "Headless", Browser.Browsers.INTERNET_EXPLORER);
                    //Log.LOGGER.error(error);
                    break;
                case CHROME:
                    this.argumentsList.add("--headless");
                    this.argumentsList.add("--no-sandbox");
                    this.argumentsList.add("--disable-dev-shm-usage");
                    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
                    this.argumentsList.add("window-size=".concat(String.valueOf(screenSize.getWidth())).concat(",").concat(String.valueOf(screenSize.getHeight())));
            }
        }

    }

    public void addExtensions(String... extensionPaths) {
        String[] var3 = extensionPaths;
        int var4 = extensionPaths.length;

        for(int var5 = 0; var5 < var4; ++var5) {
            String extensionPath = var3[var5];
            File extensionFile = new File(extensionPath);
            String error;
            switch(this.browserName) {
                case FIREFOX:
                case CHROME:
                    this.extensionsList.add(extensionFile);
                    break;
                case EDGE:
                    error = String.format("'%s' is an unsupported driver operation in any versiÃ³n of %s driver. ", "Add Extensions", Browser.Browsers.EDGE);
                    //Log.LOGGER.error(error);
                    break;
                case INTERNET_EXPLORER:
                    error = String.format("'%s' is an unsupported driver operation in any versiÃ³n of %s driver. ", "Add Extensions", Browser.Browsers.INTERNET_EXPLORER);
                    //Log.LOGGER.error(error);
            }
        }

    }

    private void applyIgnoreAlerts(boolean isIgnoreAlerts) {
        if (isIgnoreAlerts) {
            String error;
            switch(this.browserName) {
                case FIREFOX:
                    //this.firefoxPrefs.setPreference("dom.webnotifications.enabled", false);
                    break;
                case EDGE:
                    error = String.format("'%s' is an unsupported driver operation in any versiÃ³n of %s driver. ", "Ignore Alerts", Browser.Browsers.EDGE);
                    //Log.LOGGER.error(error);
                    break;
                case INTERNET_EXPLORER:
                    error = String.format("'%s' is an unsupported driver operation in any versiÃ³n of %s driver. ", "Ignore Alerts", Browser.Browsers.INTERNET_EXPLORER);
                    //Log.LOGGER.error(error);
                    break;
                case CHROME:
                    this.chromeOptions.setCapability("unexpectedAlertBehaviour", UnexpectedAlertBehaviour.ACCEPT);
            }
        }

    }

    public static enum OS {
        WINDOWS,
        LINUX,
        MAC,
        UNKNOWN;

        private OS() {
        }
    }

    public static enum Browsers {
        CHROME(Browser.chromeMap),
        FIREFOX(Browser.firefoxMap),
        EDGE(Browser.edgeMap),
        INTERNET_EXPLORER(Browser.IEMap);

        private EnumMap<Browser.OS, String> browserData;

        private Browsers(EnumMap<Browser.OS, String> data) {
            this.browserData = data;
        }

        public Map<Browser.OS, String> getDriverFileName() {
            return this.browserData;
        }

        public String getValue(Browser.OS key) {
            return (String)this.browserData.get(key);
        }

        public static Browser.Browsers OS(String value) {
            Browser.Browsers[] var1 = values();
            int var2 = var1.length;

            for(int var3 = 0; var3 < var2; ++var3) {
                Browser.Browsers data = var1[var3];
                if (data.browserData.containsValue(value)) {
                    return data;
                }
            }

            throw new IllegalArgumentException("No such driver with value : '" + value + "'");
        }

        public boolean is(Object value) {
            return this.browserData.containsValue(value);
        }

        static {
            Browser.chromeMap = new EnumMap(Browser.OS.class);
            Browser.chromeMap.put(Browser.OS.LINUX, "chromedriver");
            Browser.chromeMap.put(Browser.OS.WINDOWS, "chromedriver.exe");
            Browser.chromeMap.put(Browser.OS.MAC, "notImplemented");
            Browser.chromeMap.put(Browser.OS.UNKNOWN, "notImplemented");
            Browser.firefoxMap = new EnumMap(Browser.OS.class);
            Browser.firefoxMap.put(Browser.OS.LINUX, "geckodriver");
            Browser.firefoxMap.put(Browser.OS.WINDOWS, "geckodriver.exe");
            Browser.firefoxMap.put(Browser.OS.MAC, "notImplemented");
            Browser.firefoxMap.put(Browser.OS.UNKNOWN, "notImplemented");
            Browser.edgeMap = new EnumMap(Browser.OS.class);
            Browser.edgeMap.put(Browser.OS.LINUX, "MicrosoftWebDriver");
            Browser.edgeMap.put(Browser.OS.WINDOWS, "MicrosoftWebDriver.exe");
            Browser.edgeMap.put(Browser.OS.MAC, "notImplemented");
            Browser.edgeMap.put(Browser.OS.UNKNOWN, "notImplemented");
            Browser.IEMap = new EnumMap(Browser.OS.class);
            Browser.IEMap.put(Browser.OS.LINUX, "IEDriverServer");
            Browser.IEMap.put(Browser.OS.WINDOWS, "IEDriverServer.exe");
            Browser.IEMap.put(Browser.OS.MAC, "notImplemented");
            Browser.IEMap.put(Browser.OS.UNKNOWN, "notImplemented");
        }
    }
}

