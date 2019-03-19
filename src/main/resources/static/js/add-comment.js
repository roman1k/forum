function sendComment(){
    $("#showComments").empty();
    let nameTopic = $("#nameTopic").val();
    let textComment = $("#textComment").val();

    $.ajax({
        url: "/newComment/",
        type: 'POST',
        data: {nameTopic, textComment},
        dataType: 'json',
        cache: false,
        timeout: 600000,
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
};