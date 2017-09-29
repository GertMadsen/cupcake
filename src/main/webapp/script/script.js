/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


window.onload = function() {
    
    
    
    console.log("er er javascript!");
    
    
    var mytable = document.getElementById('ordertable');
    
    mytable.appendChild(document.createElement('tbody'));
    
    var mybody = 
        document.getElementById('ordertable').getElementsByTagName('tbody')[0];
    
    var newRow_0   = mybody.insertRow(mybody.rows.length);
    var newCell_0  = newRow_0.insertCell(0);
    var newText_0  = document.createTextNode('cell1');
    newCell_0.appendChild(newText_0);
    
    var newCell_1  = newRow_0.insertCell(1);
    var newText_1  = document.createTextNode('cell2');
    newCell_1.appendChild(newText_1);
    
    var newCell_2  = newRow_0.insertCell(2);
    var newText_2  = document.createTextNode('cell3');
    newCell_2.appendChild(newText_2);
    
    var newCell_3  = newRow_0.insertCell(3);
    var newText_3  = document.createTextNode('cell4');
    newCell_3.appendChild(newText_3);
    
    
    
   console.log("her slutter javascript!");
};

    
    /*
    var connection = new ActiveXObject("ADODB.Connection") ;

    var connectionstring="Data Source=<server>;Initial Catalog=<catalog>;User ID=<user>;Password=<password>;Provider=SQLOLEDB";

    connection.Open(connectionstring);
    var rs = new ActiveXObject("ADODB.Recordset");

    rs.Open("SELECT * FROM table", connection);
    rs.MoveFirst
    while(!rs.eof)
    {
       document.write(rs.fields(1));
       rs.movenext;
    }

    rs.close;
    connection.close; 
     */
    
    
    //var mytable = document.getElementById('ordertable').getElementsByTagName('tbody')[0];
    
    /*
    
    
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() {
        if (xhr.readyState === 4) {
            var data = xhr.responseText;
            alert(data);
        }
    };
    xhr.open('GET', 'Ordermapper', true);
    xhr.send(null);
     */


    //Order ID. 	User 	Details 	Date
    
    
    /*
    var newRow_0   = mybody.insertRow(mytable.rows.length);
    var newCell_0  = newRow_0.insertCell(0);
    var newText_0  = document.createTextNode('255');
    newCell_0.appendChild(newText_0);
    
    var newCell_1  = newRow_0.insertCell(1);
    var newText_1  = document.createTextNode('255');
    newCell_1.appendChild(newText_1);
   */
    /*
  document.getElementById("ordertable").innerHTML =
          
    "<tbody>"
    
     + "<tr><td>" + 255 + "</td><td>" + "Hans" + "</td>"
                    + "<td><a href=\"showOrderInfo.jsp?orderId=" + 2 + "\"> View this order </a></td>"
                    + "<td>" + 2017 + "</td></tr>";
    
     + "</tbody>";
    */