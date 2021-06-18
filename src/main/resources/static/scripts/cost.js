// process live cost price of reservation form

$('.form-group').on('input', '.prc', function () {

  var totalPrice = 0;
  var counter = 0;

  $('.form-group .prc').each(function () {
    var inputVal = $(this).val();
   // var totalPrice = parseInt($('#hotel-price').val(),10);
    if (inputVal.includes("Single")) {
      totalPrice = parseInt($('#hotel-price').val(),10);
    }

    if (inputVal.includes("Double")) {
      totalPrice = parseInt($('#hotel-price').val(),10)+300;
    }

    if (inputVal.includes("Family")) {
      totalPrice = parseInt($('#hotel-price').val(),10)+400;
    }

    if (inputVal.includes("Honeymoon")) {
      totalPrice = parseInt($('#hotel-price').val(),10)+500;
    }

    if (inputVal.includes("Suite")) {
      totalPrice += 200;
    }

    if (inputVal.includes("Deluxe")) {
      totalPrice += 200;
    }

    if (inputVal.includes("YES")) {
      totalPrice += 200;
    }

    if ($.isNumeric(inputVal)) {
    	
      if (counter == 3) {
        totalPrice += (inputVal * 80);
      }

      if (counter == 4) {
        totalPrice += (inputVal * 400);
      }

      if (counter == 5) {
        totalPrice += (inputVal * 60);
      }

      if (counter == 6) {
        totalPrice += (inputVal * 10);
      }
    }

    counter++;
  });

  document.getElementById('priceField').value = totalPrice;
  $('#price-count').text(totalPrice);

});