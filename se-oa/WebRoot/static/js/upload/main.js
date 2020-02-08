/*
 * jQuery File Upload Plugin JS Example
 * https://github.com/blueimp/jQuery-File-Upload
 *
 * Copyright 2010, Sebastian Tschan
 * https://blueimp.net
 *
 * Licensed under the MIT license:
 * http://www.opensource.org/licenses/MIT
 */

/* global $, window */

$(function () {
    'use strict';

    // Initialize the jQuery File Upload widget:
    $('#fileupload').fileupload({
        url: '/media/upload'
    });

    // Enable iframe cross-domain access via redirect option:
    $('#fileupload').fileupload(
        'option',
        'redirect',
        window.location.href.replace(
                /\/[^\/]*$/,
                '/cors/result.html?%s'
            )
    );
    
        // Load existing files:
/*    
    $.ajax({
    	type: 'POST',
        url: $('#fileupload').fileupload('option', 'url'),
        dataType: 'json',
        data: {mediaListForm:$("#fileupload").serialize()},
        context: $('#fileupload')[0]
    }).done(function (result) {
        $(this).fileupload('option', 'done')
            .call(this, $.Event('done'), {result: result});
    });
*/
//    $('#fileupload').fileupload('option', {
//        url: '/media/upload',
//        disableImageResize: /Android(?!.*Chrome)|Opera/
//            .test(window.navigator.userAgent),
//        maxFileSize: 999000,
//        acceptFileTypes: /(\.|\/)(gif|jpe?g|png)$/i
//    });
//    // Upload server status check for browsers with CORS support:
//    if ($.support.cors) {
//        $.ajax({
//            url: '/media/upload',
//            type: 'POST',
//            data: {$("#fileupload").serialize()}
//        }).fail(function () {
//            $('<div class="alert alert-danger"/>')
//                .text('Upload server currently unavailable - ' +
//                        new Date())
//                .appendTo('#fileupload');
//        });
//    }
});
