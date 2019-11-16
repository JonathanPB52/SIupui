$(document).ready(function() {

    $('#button-menu').click(function() {

        if ($('#button-menu').attr('class') === 'fas fa-bars') {
            $('#button-menu').removeClass('fas fa-bars').addClass('fas fa-times');
            $('.navegacion .menu').css({ 'left': '0px' });
            $('.navegacion ').css({ 'width': '100%' });



        } else {
            $('#button-menu').removeClass('fas fa-times').addClass('fas fa-bars');
            $('.navegacion .menu').css({ 'left': '-270px' });
            $('.navegacion .submenu').css({ 'left': '-270px' });
            $('.navegacion ').css({ 'width': '0%' });
        }


    });

    $('.navegacion .menu > .item-submenu a').click(function() {
        var positionMenu = $(this).parent().attr('menu');

        $('.item-submenu[menu='+positionMenu+'] .submenu').css({ 'left': '0' });
    });

    $('.navegacion .submenu li.atras').click(function() {
        $(this).parent().css({ 'left': '-270px' })
    });

});