const MODAL_ID='actlater-modal-root';
const BUTTON_ID='actlater-floating-button';
function ensureActLater(){
  if(document.getElementById(BUTTON_ID)) return;
  const button=document.createElement('button');
  button.id=BUTTON_ID;
  button.className='floating';
  button.type='button';
  button.textContent='Try Later';
  document.documentElement.append(button);
  const modal=document.createElement('div');
  modal.id=MODAL_ID;
  modal.className='modal hidden';
  document.documentElement.append(modal);
  button.addEventListener('click',()=>{
    modal.classList.toggle('hidden');
    if(!modal.dataset.ready){
      createReminderForm(modal,{title:document.title,url:location.href,sourceTitle:document.title});
      modal.dataset.ready='true';
    }
  });
}
ensureActLater();
