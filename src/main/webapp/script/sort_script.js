/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var sortuser = document.getElementById("sortuser");
var sortdate = document.getElementById("sortdate");


sortuser.onclick = function () {
    var tbody = document.getElementsByTagName("tbody")[0];
    var tableRows = tbody.getElementsByTagName("tr");
    var data = dataFromElements(tableRows);

    data.sort(function (x, y) {
        return (x.user < y.user) ? -1 : ((x.user > y.user) ? 1 : 0);
    });
    var newRows = data.map(function (obj) {
        return "<tr><td>" + obj.id + "</td>" + "<td>" + obj.user + "</td>" + "<td>" + obj.details + "</td>" + "<td>" + obj.date + "</td></tr>";
    }).reduce(function (accumulator, currentValue) {
        return accumulator + currentValue;
    });
    tbody.innerHTML = newRows;
};

sortdate.onclick = function () {
    var tbody = document.getElementsByTagName("tbody")[0];
    var tableRows = tbody.getElementsByTagName("tr");
    var data = dataFromElements(tableRows);

    data.sort(function (x, y) {
        return (x.id - y.id);
    });
    var newRows = data.map(function (obj) {
        return "<tr><td>" + obj.id + "</td>" + "<td>" + obj.user + "</td>" + "<td>" + obj.details + "</td>" + "<td>" + obj.date + "</td></tr>";
    }).reduce(function (accumulator, currentValue) {
        return accumulator + currentValue;
    });
    tbody.innerHTML = newRows;
};


function dataFromElements(tableRows) {
    //this function takes a collection of table row elements. for each row the collection of <td>s are taken.
    //then the innerText of each <td> element is taken and is attached to an object as one of its properties.
    //the object is pushed on the array
    result = [];
    for (var i = 0; i < tableRows.length; i++) {
        var tds = tableRows[i].getElementsByTagName("td");
        if (tds[0].innerText !== 'Total') {
            var obj = {};
            obj.id = tds[0].innerText;
            obj.user = tds[1].innerText;
            obj.details = tds[2].innerText;
            obj.date = tds[3].innerText;
            result.push(obj);
        }
    }
    return result;
}
