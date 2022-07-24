# MACHINE STOP GRAPH

As an internship project, this data visualisation project is done for the company Orta Anadolu.

Plotly Javascript open source graphing library is used to sketch the graph. PHP is used to fetch data from the database. XAMPP is used for Apache and MySQL.

## Watch the Video:
[click to watch](https://user-images.githubusercontent.com/89942570/180644531-f163e9e4-a216-4e98-850b-dbfed88a208e.mp4)

## Explanation of the graph:

 <img src="https://user-images.githubusercontent.com/89942570/180643621-ae2e3394-93c4-4601-a8c8-8b2fbe706d80.png">

On the y-axis, there are machine names and on the x-axis, there is a time range. The user enters a time range to see the stop data of machines. When pressing the show button, the graph is plotted. 

There are three reasons for a machine to stop: failure, maintenance, and break time. Based on the reason of stop, the time interval where the machine stops is demonstrated by a colour, red for failure, green for break time, and orange for maintenance.

## Features:

1. **Zoom in and zoom out:** The user can zoom in to take a closer look at the data.
2. **Hover:** When hovering at any point, detailed information about the machine is shown in a black box.
3. **Click:** When clicking on a point, a box on the right bottom appears to show the details.

Besides, the time range input is evaluated and if the time range is not valid an alert is shown and the graph is cleaned.

## See the photos:

Entering invalid time range:

<img src="https://user-images.githubusercontent.com/89942570/180643624-4c8cdce9-3aa6-4924-906b-8d7fce298010.png">

<img src="https://user-images.githubusercontent.com/89942570/180643631-2099c96b-d2dc-4c41-af7a-16c7fa887280.png">

<img src="https://user-images.githubusercontent.com/89942570/180643632-60de5389-2de8-42b1-af46-5bd0fded2d35.png">

---

When no data found:

<img src="https://user-images.githubusercontent.com/89942570/180643634-f906f320-27e9-462b-8037-53a670d2a5c0.png">

<img src="https://user-images.githubusercontent.com/89942570/180643636-844161d5-b47e-4a25-b7a8-df7412f66ed2.png">

---

Database table:

<img src="https://user-images.githubusercontent.com/89942570/180643783-193b5031-0c9f-431f-a4b6-03f1d27eda3d.png">