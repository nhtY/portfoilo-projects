// start ve end arasına noktalar koyulmuştu. Bu noktaların sayısının çok olması performansı
// etkileyebilir. Zaman farkına göre aralığı ayarlayabilirsin. Fark 1 saatten azsa 1 dk lık, 1-3 saat ise 5 dk lık
// ... gibi aralıklar ayarlanabilir.

// grafiğin gösterileceği html elementini myPlot değişkeninde tut:
var myPlot = document.getElementById('ganttContainer'); 

// Grafik üzerindeki çizgilerin uç noktalarına hover olunca
// detaylı bilgilerin yazdırılacağı html elementini hoverInfo değişkeninde tut.
let hoverInfo = document.getElementById('hoverinfo');

// makine verilerinin tutulacağı obje:
var machineData = {
  'data': [],
};

/*
* Makinelere dair verileri, gruplanmış şekilde data değişkeni içinde tut.
* Makine bilgileri gruplanmış şekilde sırayla gelmeli.
* ÖR: machine-1, machine-1, machine-2, machine-2, machine-2, machine-3,...
*/
// var data =[
//       // machine-1
//   {
//     "startDate":"2022-07-04 04:00",
//     "endDate": "2022-07-04 04:50",
//     "machineName":"sewing-1",
//     "reasonOfStop":"failure",
//     "color": 'red' // gerek yok pickLineColor metodu var.
//   },  
//   {
//     "startDate":"2022-07-05 04:00",
//     "endDate": "2022-07-05 05:25",
//     "machineName":"sewing-1",
//     "reasonOfStop":"maintanence",
//     "color": 'orange' // gerek yok pickLineColor metodu var.
//   },
//   {
//     "startDate":"2022-07-05 17:02",
//     "endDate": "2022-07-05 20:01",
//     "machineName":"sewing-1",
//     "reasonOfStop":"break",
//     "color": 'green' // gerek yok pickLineColor metodu var.
//   },
  

//   // machine-2
//   {
//     "startDate":"2022-07-04 12:02:30",
//     "endDate": "2022-07-04 13:02:48",
//     "machineName":"sewing-2",
//     "reasonOfStop":"failure",
//     "color": 'red' // gerek yok pickLineColor metodu var.
//   },
//   {
//     "startDate":"2022-07-04 20:02:30",
//     "endDate": "2022-07-04 20:52:10",
//     "machineName":"sewing-2",
//     "reasonOfStop":"break",
//     "color": 'green' // gerek yok pickLineColor metodu var. 
//   },
//     {
//     "startDate":"2022-07-05 08:02:30",
//     "endDate": "2022-07-05 10:00:18",
//     "machineName":"sewing-2",
//     "reasonOfStop":"maintanence",
//     "color": 'orange' // gerek yok pickLineColor metodu var.
//   },

//   // machine-3
//   {
//     "startDate":"2022-07-04 04:00",
//     "endDate": "2022-07-04 19:59",
//     "machineName":"weaving machine-1asdasd asdasd",
//     "reasonOfStop":"failure",
//     "color": 'red' // gerek yok pickLineColor metodu var.
//   },
//   // makinelerin bilgisi sırayla geliyor. (öyle olduğu varsayılıyor.)
// ]; 


/* Herbir stop aralığı için grafikte çizgiler olacak
* çizgilere dair verileri traces içinde tut.
*/
var traces = [];

// y-eksenindeki değerler
var y_values = []; // 1,2,3,4 --> level count ile doldur.

// y eksenindeki değerlere karşılık gelen makine isimleri, veritabanından çekilecek.
var machines = []; // 1 --> 'Machine-1', 2 --> 'Machine-2', ...

var levelCount = 1; // y eksenindeki değerler. Her makine türü tek bir satıra dizilecek.

/*** Show butonuna basılınca veriyi temizle. Yoksa üst üste grafik çizer. */ 
function clearData() {

  // Her bir stop için çizilen çizgilere ait verilerin tutulduğu array.
  traces = [];

  // y-eksenindeki değerler
  y_values = []; 
  
  // y eksenindeki değerlere karşılık gelen makine isimleri, veritabanından çekilecek.
  machines = []; 
  
  // y eksenindeki değerler. Her makine türü tek bir satıra dizilecek. 
  levelCount = 1;
  
  // veritabanından çekilen değerlerin tutulduğu obje.
  machineData.data = [];

  // noktaya tıklanınca beliren kutuyu temizle.
  clearHoverInfo();
}

/**
 * Show butonuna basılınca hoverInfo alanını temizler.
 */
function clearHoverInfo() {
  // show butonuna basılınca ilgili html tag'inde tutulan verileri temizle:
  hoverInfo.innerHTML = '';
  hoverInfo.style.border = '0px';
  hoverInfo.style.width = '96%';
  hoverInfo.style.height = '100%';
  hoverInfo.style.backgroundColor = 'transparent';
  hoverInfo.style.overflow = 'hidden';
}

/**
 * Herbir stop aralığı için grafikte çizilecek çizgileri verilere göre hazırla.
 * @param {boolean} isInitial - sayfa yüklenirken veya refresh edilince TRUE; show butonuna basınca FALSE.
 * @returns list of trace/her bir line bilgisinin listesi
 */
function getTraces(isInitial) {
    if(isInitial) return traces;

    if(machineData != null){
      console.log(machineData);
      console.log(machineData.data);
      machineData.data.forEach(function(dt,index){
        // makinenin adına göre çizginin hangi satırda olacağını belirle
        updateInfoYaxis(dt.name);
      
        // makinenin durma sebebine göre çizgi rengi belirle
        var lineColor = pickLineColor(dt.reasonOfStop);
        console.log(lineColor);

        // start ve end arasına noktalar yerleştir. Hover olunca verileri görmeye yarar.
        const xAndY = fillTheInterval(dt.stopBegin, dt.stopEnd, levelCount);
      
        // çizgi bilgilerini hazırla
        var trace = {
          machineName: dt.name,
          name: dt.reasonOfStop,
          x: xAndY['x'],//[dt.startDate, dt.endDate],
          y: xAndY['y'],//[levelCount, levelCount],
          type: 'scatter',
          mode: 'lines+markers',
          marker : {
            symbol : 'diamond',
            color : 'black',
            size: 2,
          },
          line:{width:8, color : lineColor},
          showlegend:false,
          // hover olunca ne göreceğini belirle:
          hovertemplate: '<b><i>Machine Name</i></b>: ' + dt.name + 
                            '<br><b>Reason of Stop</b>: '+ dt.reasonOfStop +
                            '<br><b>Stop begin</b>: ' + dt.stopBegin +
                            '<br><b>Stop end</b>: ' + dt.stopEnd +
                            '<extra></extra>'
      
        };
      
        // çizgi bilgilerini traces'e ekle.
        traces.push(trace);
      });
    }
    
    return traces;
}

/**
 * y-ekseninde, bilgilerin hangi makinenin satırına ekleneceğini belirler.
 * Eğer traces'e eklenen son makineden(ÖR: sewing) farklı bir makine(ÖR: waeving) veri olarak gelirse
 * onun bilgilerini y-ekseninde bir üst sırada gösterir.
 * @param {string} newComerMachineName - makine adı
 */
function updateInfoYaxis(newComerMachineName) {
  console.log(traces.length);
  console.log(newComerMachineName);

  if (traces.length != 0) {
    var lastElementMachineName = traces[traces.length -1].machineName;
    console.log("working inner 1..")
    if (newComerMachineName != lastElementMachineName) {
      levelCount += 1;
      y_values.push(levelCount);
      // y-ekseninde görülen makine isminin maksimum uzunluğunu ayarla:
      machines.push(newComerMachineName.slice(0, 20));
      console.log("working inner 2..")

    }

  } else {
    y_values.push(levelCount);
    machines.push(newComerMachineName);
  }
}

/**
 * makinenin durma nedenine göre çizginin rengini belirler.
 * @param {string} reasonOfStop - makinenin durma nedeni
 * @returns color-renk ÖR: 'blue'
 */ 
function pickLineColor(reasonOfStop){
  if (reasonOfStop == 'failure')
    return 'red';
   
  if (reasonOfStop == 'break')
    return 'green';

  if (reasonOfStop == 'maintanence')
    return 'orange';
}

/**
 * İlgili state için start ve end arasına eşit aralıklarla nokta (x değerleri) ekler.
 * Bu x değerlerinden oluşan array'i, çizgi bilgilerinin hazırlandığı kısımda (getTraces) x: kısmına ver.
 * Böylece sadece uç noktlarda değil aralarda da hover özelliği kullanılabilir.
 * @param {*} startTime - İlgili makinenin ilgili state'i için başlangıç tarih ve saati.
 * @param {*} endTime - İlgili makinenin ilgili state'i için bitiş tarih ve saati.
 * @param {*} levelCount - çizginin y-eksenindeki seviyesi.
 * @returns {[x1, x2, ..., ...], [y1, y2, ..., ...]} burada y'ler levelCount a eşit.
 */
function fillTheInterval(startTime, endTime, levelCount){
  const timeRange = [new Date(startTime), new Date(endTime)];
  const d1 = timeRange[0];
  const d2 = timeRange[1];
  var difference = Math.abs(d2 - d1);
  var minuteLimit = (difference/1000)/60; // dk.
  minuteLimit = Math.ceil(minuteLimit);

  const [date, time] = startTime.split(' ');
  const [year, month, day] = date.split('-');
  const [hour, minute] = time.split(':');

  const myDate = new Date(+year, +month - 1, +day, hour, minute);

  const dates = [];
  dates.push(startTime);
  
  y_axis = [];
  y_axis.push(levelCount);

  var step = calculateDistance(minuteLimit);
  console.log(step);

  for(var i=0; i<Math.floor(minuteLimit/step); i++){
    const date = new Date(myDate.setMinutes(myDate.getMinutes() + step));
    
    dates.push(date.toLocaleString('sv'));

    console.log(date.toLocaleString('sv'));
    y_axis.push(levelCount);
  }

  dates.push(endTime);
  y_axis.push(levelCount);

  const axisData = {};
  axisData['x'] = dates;
  axisData['y'] = y_axis;

  return axisData;

}

/**
 * İlgili state'in başlangıç ve bitişi arasına konulan noktalar arası mesafeyi, state'in
 * ne kadar sürdüğüne bağlı olarak belirler.
 * @param {Array} range - [stateBaslangıc, stateBitis]
 * @returns int - dakika cinsinden aralık.
 */
function calculateDistance(range){

  if (range<=10) {
    return 1;
  } 
  if (range<=60) {
    return 5;
  }
  if (range<=180) {
    return 10;
  }
  if (range<=360) {
    return 15;
  }
  return 40;
}
/**
 * Grafiğin sol üstünde beliren butonları, girilen zaman aralığı bilgisine göre belirler.
 * ÖR: Zaman aralığı bir günden azsa all, 15min ve 1h butonlarını seçer.
 * @param {Array} range 
 * @returns Secili butonların bulunduğu listeyi döndürür.
 */
function getSelectorOptions(range) {
    /* Çekilen verinin zaman aralığını dakika cinsinden hesapla. */
    const timeRange = [new Date(range[0]), new Date(range[1])];
    const d1 = timeRange[0];
    const d2 = timeRange[1];
    var difference = Math.abs(d2 - d1);
    var minuteLimit = (difference/1000)/60; // dk.
    minuteLimit = parseFloat(minuteLimit).toFixed(2);

    console.log(minuteLimit);

    /* Grafik üzerinde bulunacak butonlar için seçenekler */
    const selectorOptions = {
        buttons: [{
            step : 'minute',
            stepmode : 'backward',
            count : 15,
            label : '15min',
            minutes : 15 
        }, {
            step : 'hour',
            stepmode : 'backward', // backward olursa en son tarihten önceki aralığa gidiyor.
            count : 1,
            label : '1h',
            minutes : 60
        }, {
            step : 'day',
            stepmode : 'backward',
            count : 1,
            label : '1d',
            minutes : 1440
        }, {
            step : 'week',
            stepmode : 'backward',
            count : 1,
            label : '1w',
            minutes : 10080
        }, {
            step : 'month',
            stepmode : 'backward',
            count : 1,
            label : '1m',
            minutes : 302400
        }, 
        //{
        //     step: 'all',
        // }
        ],
    };

    // Şartları sağlayan butonları buttons içinde tut.
    var buttons = [{
    step: 'all',
    stepmode: 'todate'
    },];

    // buttons değişkeni filteredSelectorOptions içinde duracak.
    var filteredSelectorOptions = {};


    /* Grafik üzerinde bulunacak butonları belirler. Verilerin zaman aralığı 2 gün ise
    * grafiği son 1 haftayı gösterecek şekilde ayarlayacak butonu koymak anlamsız. 
    */
    filteredSelectorOptions.buttons = selectorOptions.buttons.forEach(function(option){
    if (option.minutes <= minuteLimit){
        buttons.push(option);
        console.log(option);
        console.log(buttons);
    }
        
    });

    // buttons değişkenini filteredSelectorOptions içinde tut.
    filteredSelectorOptions['buttons'] = buttons;

    console.log(filteredSelectorOptions.buttons); // debug print.

    return filteredSelectorOptions;
}

/**
 * grafiğin layout özelliklerini belirle:
 * @param {bool} isInitial - Ekran yülneniyorsa veya refresh ise TRUE; Show butonuna basıldıysa FALSE
 * @param {Array} range - Kullanıcının girdiği tarih aralığı.
 * @returns grafiğin layout özelliklerinin listesi {}.
 */
function getLayout(isInitial, range) {
    var layout = {
        paper_bgcolor: '#5885AF',
        plot_bgcolor: '#C3E0E5',
        // title : 'Machine Stop Data',
        hovermode : 'closest',
        autosize : true,
        // height verilebilir.
      
        // x-ekseni:
        xaxis : {
          //automargin: true,
          tickcolor: '#274472',
          nticks : 16,
          zeroline : false,
          range : range,//["2016-02-01 03:30", "2016-02-01 11:00"] ,//timeRange, // zaman aralığı, girilmese de olur.
          fixedrange : false, // true ise mouse ile zoom yapılamıyor.
          rangeselector : isInitial==true? null : getSelectorOptions(range),
          rangeslider : {
            bordercolor : '#27c4b5',
            borderwidth : 2,
            //rangemode : "fixed", // 
            thickness : 0.2,
            range : range, 
          },
          title : '<b>Date and Time<b>',
          titlefont : {
            size : 14,
            color: 'azure',
          },
          tickmode:'auto', // 'array' idi. 'auto' olunca belirlenen ntick değerine göre tick sayısı ayarlanıyor.
          tickfont : {
            size: 10,
            color: 'azure',
          },
          showgrid: true,
          zerolinecolor : '#969696',
          zerolinewidth : 1,
        },
      
        // y-ekseni
        yaxis: {
          tickcolor: '#274472',
          automargin: true,
          fixedrange : true,
          title : '<b>Machine Names<b><br>',
          tickvals : isInitial==true? null : y_values,
          ticktext : isInitial==true? null : machines,
          visible : true,
          titlefont : {
            size: 14,
            color: 'azure',
          },
          tickfont : {
            size: 10,
            color: 'azure',
          },
          showgrid : true,
          zerolinecolor : '#969696',
          zerolinewidth : 1,
          
        },
        // 
        legend: {
          orientation: 'h',
          x: 0.5,
          y: 0.5,
          xanchor: 'center',
        },
        margin: {
          // automargin yaptım: xaxis ve yaxis'e bak.
          //l: 160, // bu değer, y-ekseninde bulunan makine isimlerinin okunurluğuna etki ediyor!
          b: 0,
          r: 8,
          t: 0,
          //pad: 8
        },
      };
    return layout;
}

/**
 * Grafik konfigurasyonlarini beliler.
 * @returns Grafik konfigurasyonlari
 */
function getConfig() {
    var config = {
        scrollZoom: true, 
        displaylogo: false,
        responsive: true,
        modeBarButtonsToRemove: ['autoScale2d', 'resetScale2d', 'select2d', 'lasso2d', 'zoom2d', 'toggleSpikelines'],
        modeBarButtonsToAdd: [
          {
            // tıklanınca bozulan slider range'i düzelt (2 tık gerekiyor )-: )
            name: 'fix slider',
            icon: Plotly.Icons.pencil,
            click: function(gd)  {
                var range = getRangeInput();
                var update = {
                    'xaxis.rangeslider.range' : range,
                    'xaxis.range': range,
                };
                Plotly.relayout(gd, update);
                console.log("fix slider is clicked!");
            }
          }, 
        ],
    };
    return config;
}

// Grafiği oluştur (initial):
// Mouse ile scroll yapınca zoom in veya out yapılabiliyor. Ancak x-axis için 'fixedrange : false' olmalı.
Plotly.newPlot(myPlot, getTraces(true), getLayout(true), getConfig());
onClick();

console.log(greeting);

/**
 * Zaman aralığı bilgisini kullanıcıdan alır.
 * @returns [start, end], ÖR: [2022-07-20 15:00, 2022-07-21 15:45]
 */
function getRangeInput() {

	var start = document.getElementById("rangeStart").value;
  var end = document.getElementById("rangeEnd").value;
    
    
    
  if(start == '' && end == ''){
    window.alert("You did not enter a valid range!");
    return;
    // var range = generateDate();
    // return range;
  }else {
  start = start.replace("T", " ");
  end = end.replace("T", " ");
  
  const d1 = new Date(start);
  const d2 = new Date(end);
    
    if(d1<d2){
      return [start, end];
    }else {
        window.alert("You did not enter a valid range!");
        return;
      // var range = generateDate();
      // return range;
    }
  }       
}

/**
 * Kullanıcı range için input girmezse tıklama anına göre 1 saatlik range oluşturur.
 * @returns [start, end], ÖR: [2022-07-20 15:00, 2022-07-21 15:45]
 */
function generateDate() {

  const d = new Date()
  end = d.toLocaleString('sv');

  const d2 = new Date(d.setHours(d.getHours()-1));
  start = d2.toLocaleString('sv');
  return [start, end]; // 2022-07-20 21:14

}




/**
 * Show butonuna basılınca girilen tarih aralığına göre grafiği oluşturur.
 */
function showGraph() {
  // kullanıcıdan tarih aralığını al:
  var range = getRangeInput();

  // grafiği çizmeden, önceki verileri temizle:
  clearData();

  // veritabanından veriyi çek:
  fetchData(range);

  // verilere göre grafiği çiz:
  Plotly.newPlot(myPlot, getTraces(false), getLayout(false, range), getConfig());
    
  // noktaya tıklanınca olacakları ayarla:
  onClick();

  // girilen aralık için veri yoksa kullanıcıya bildir:
  if(machineData.data.length == 0){
    window.alert("No data found within the entered time interval! Enter different date values!");
  }
  
 
}

/**
 * Kullanıcı tarafından girilen tarih aralığındaki stop bilgilerini getir.
 * @param {array} inputRange 
 */
function fetchData(inputRange) {
  // sql query'sinde kullanılacak verileri hazırla:
  const range = {"rangeStart": inputRange[0], "rangeEnd":inputRange[1]};
  const dbParam = JSON.stringify(range);

  xmlhttp = new XMLHttpRequest();

  // "Veri gelince" ne yapsın:
  xmlhttp.onload = function() {
    console.log("..data is fetched..");
    // text olarak gelen veriyi objeye çevir.
    var fetchedData = this.responseText;

    if(fetchedData.includes("Error")){
      window.alert(fetchedData);
      return;
    }

    fetchedData = JSON.parse(fetchedData);
    
    // çekilen veriyi machineData objesinin data attribute'ı içinde tut.
    for(var i=0; i<fetchedData.length; i++) {
      machineData.data.push(fetchedData[i]);
      console.log(machineData.data);
    }
  }
  // sql query'si için hazırlanan verileri php'ye yolla. 'false' verinin gelmesini beklemek için
  xmlhttp.open("GET","fetch_data.php?x=" + dbParam, false);
  xmlhttp.send();
}

/**
 * Bozulan slider aralığını ve x-ekseni aralığını, kullanıcının girdiği tarih aralığına
 * göre ayarlar.
 */
function fixSliderRange()  {
    var range = getRangeInput();

    var update = {
        'xaxis.rangeslider.range' : range,
        'xaxis.range': range,
    };

    Plotly.relayout(myPlot, update);
    // Plotly.relayout(myPlot, , newRange);
    console.log("fix slider is clicked!");
}

/**
 * Hover olunca grafiğin alt tarafındaki kutuda, hover olunan noktanın detaylı bilgisi gösterilir.
 * Noktaya tıklanması gerekiyor.
 */
function onClick() {
    // Noktaya tıklanınca olunca grafiğin altında, grafikten bağımsız olarak, ilgili noktaya dair bilgileri göster.
    myPlot.on('plotly_click', function(data){

        // gösterilecek texti belirle (Çoklu):
        // var infotext = data.points.map(function(d){
        //   return ("<b>Machine Name</b>: "+ d.data.machineName+ ",<br> <b>Reason of Stop</b>: "+d.data.name
        //                       +',<br> <b>dateStateBegin</b>: '+d.data.x[0] + ",<br> <b>dateStateEnd</b>: " + d.data.x[1]);//, y= '+d.y.toPrecision(3)
        // });
    
        // tek nokta: (çoklu hover olunca da tek nokta için gösterir)
        var pointData = data.points[0].data;
        console.log(pointData);
        var infotext = "<b>Machine Name</b>: <br> <i>"+ pointData.machineName+ "</i>,<hr><b>Reason of Stop</b>: <br>"+pointData.name
                            +',<hr> <b>dateStateBegin</b>: <br>'+pointData.x[0] + ",<hr> <b>dateStateEnd</b>: <br>" + pointData.x[pointData.x.length -1];
        
        
        console.log(infotext); // debug print
    
        // ilgili html tag'i için stil özellikleri:
        hoverInfo.innerHTML = infotext; //.join('<br>')
        hoverInfo.style.border = '4px solid #274472';
        hoverInfo.style.textAlign = 'center';
        hoverInfo.style.display = 'block';
        hoverInfo.style.backgroundColor = '#5885AF';
        hoverInfo.style.color = 'azure';
        hoverInfo.style.borderRadius = '8px';
    
        hoverInfo.style.width = '96%';
        hoverInfo.style.height = '96%';
        hoverInfo.style.margin = 'auto';
    
        hoverInfo.style.overflow = 'scroll';
    })
    /*.on('plotly_unhover', function(data){
      üstteki click değil de hover olsaydı. unhover olunca ne olacağını buraya yazardık.
        
    })*/; 
    
    
    
    /* Yukarıdaki hover özelliği için farklı kullanım örneği aşağıda:
    
    hover edilen noktanın x ve y koordinat bilgisi(makine adı, datetime) için:
    
    myPlot.on('plotly_hover', function(data){
        var infotext = data.points.map(function(d){
        return ('x data = '+d.x + ', y data= '+d.y);  // for precision: d.y.toPrecision(3)
        });
    
        console.log(infotext); // debug print
    
        hoverInfo.innerHTML = infotext.join('<br>');
    })
    .on('plotly_unhover', function(data){
        hoverInfo.innerHTML = '';
    }); 
    */
}
