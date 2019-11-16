function mensaje() {
    alertify.alert("HEADER", "Esto es un mensaje").set('label', 'Aceptar');
}
function confirmar() {
    var confirm = alertify.confirm('Probando confirm', 'Confirmar solicitud?', null, null).set('labels', {ok: 'Confirmar', cancel: 'Cancelar'});

    //callbak al pulsar botón positivo
    confirm.set('onok', function () {
        alertify.success('Has confirmado');
    });
    //callbak al pulsar botón negativo
    confirm.set('oncancel', function () {
        alertify.error('Has Cancelado el dialog');
    })

}


