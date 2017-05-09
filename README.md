SkyProbe - UAV for Crisis Probing
===================

SkyProbe is an Unmanned Aerial Vehicle based on DJI Phantom 4, incorporating Clarifai Computer Vision API which can detect natural crisis such as forest fires and debris flows in rural areas.

**This project is the final 9 projects out of 60 competing teams at HACKxFDU and was awarded DJI Innovation and Entrepreneurship Award.**


Hardwares Specifications
------------
SkyProbe concept uses the following hardware:

- DJI Phantom 4, a consumer-grade 4-axis aerial drone pre-equipped with one main camera with 180 degree vision and four auxiliary cameras. Product link: <http://www.dji.com/phantom-4>
- Ruff Internet of Things kit, a JavaScript-based IoT kit which is very user-friendly to newbies, especially for the front-end developers who are unfamiliar with hardware and wiring. Ruff is a JavaScript runtime specialized in IoT development. Ruff makes embedded coding easy and more efficient by providing HAL, asynchronous I/O, and event-driven programming. Product link: <http://www.ruff.io>

External APIs
-------------

This project uses external APIs for demonstration purposes. The list of APIs used is shown below:

- DJI Development SDK: <http://developer.dji.com>
- Clarifai Computer Vision and Image Recognition API: <https://developer.clarifai.com/>
- Ruff Development SDK: <https://ruff.io/api/adc.html>


API Keys
-------------

To use this demo, please signup or login to <http://developer.dji.com> and <http://developer.clarifai.com> create an application and obtain an API AppID Key. In the Android Application, locate to src/string.xml and replace
```
dji_api_key = 'Enter your DJI API key here...'
clarifai_api_key = 'Enter your Clarifai API key here...'
```

to your API key obtained from DJI and Clarifai.

Misc.
-------------------

This demo is developed by Shaolin Zhang and Yiluo Li. A project for HACKxFDU on October 14-16, 2016, using DJI Phantom 4 and Ruff IoT Kit as Hardware and DJI Mobile SDK, Clarifai CV API and Ruff SDK as Software.

License
-------------------

This project is licensed under MIT License.

Copyright (c) 2016 Shaolin Zhang and Yiluo Li.

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
