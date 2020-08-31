
$('#password, #confirmPassword')
    .on('keyup', function() 
            {
                if ($('#password').val() == $('#confirmPassword').val()) 
                {
                    $('#message').html('비밀번호가 일치합니다').css('color', 'green');
                } 
                else
                {
                    $('#message').html('비밀번호가 일치하지 않습니다').css('color', 'red');
                }
            });
