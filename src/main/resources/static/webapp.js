var webapp = (function () {
    function sortNumbers() {
        var data = document.getElementById('inputNumbers').value;
        axios.post('https://parcial1arepnicolasaguilerac.herokuapp.com/calculate/sort/', data)
            .then(res => {
                var values = JSON.parse(res.data);
                document.getElementById("sortedList").innerHTML = "Sorted List : "+"["+ values.List + "]";
                document.getElementById("sum").innerHTML = "Sum : "+"["+ values.sum + "]";
                document.getElementById("average").innerHTML = "Average : "+"["+ values.avg + "]";


            })
            .catch(function (err) {
                console.log(err);
            })
    }
    return {
        sortNumbers:sortNumbers
    };
})();