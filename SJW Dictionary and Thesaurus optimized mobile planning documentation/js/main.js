$(function() { 
    $('#sidebarCollapse').on('click', function() {
      $('#sidebar, #content').toggleClass('active');
    });
  });

  $(function() { 
  $('#scrollToTop').on('click', function() {
    window.scrollTo({top: 0, behavior:'smooth'});
})});