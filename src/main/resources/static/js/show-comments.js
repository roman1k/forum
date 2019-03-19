$(document).ready(function(){
    let nameTopic = $("#nameTopic").val();
    console.log(nameTopic);
    $.ajax({
        url: "/showComments/",
        type: 'GET',
        data: {nameTopic},
        dataType: 'json',

        success:
            function (response) {
                console.log(response)
                for (const singleComment of response) {
                    let present = $('<div/>',{
                        text:  singleComment.text
                    });
                    $("#showComments").append(present);
                }
            },
        error: function (err) {
            console.log(err)
        }
    })
});