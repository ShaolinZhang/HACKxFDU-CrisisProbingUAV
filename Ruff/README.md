Ruff Application
======================
Ruff is a JavaScript runtime specialized in Internet of Things development. Ruff makes embedded coding easy and more efficient by providing HAL, asynchronous I/O, event-driven programming.
For more information, please visit <https://ruff.io/>.
This is the code used for collecting temperature, relative humidity, and luminosity through Ruff Internet of Things Kit.

Deploying and Running
----------------------
- First, please download the Ruff SDK from <https://ruff.io/docs/download.html>, and extract the contents.
- Open the terminal, go to your Ruff SDK folder.
- Execute ```rap --version``` in the command line. If the version of rap is printed as expected, ```PATH``` has been successfully configured.
- Now go to this Ruff application folder in the terminal
- Connect the micro USB port on the Ruff development board with a USB power cable. After development board boots up, it will setup a hotspot named as ```Ruff-[SN]```(```[SN]``` is a serial number of the board). Connect your computer to this hotspot. The hotspot does not provide no internet access.
- Now go back to the terminal. Run the following command:
```
rap deploy -s 
```
- If everything goes well, you should start to see feedback printed in the terminal.
