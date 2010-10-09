package br.com.chapecosolucoes.trafegusweb.client.controller
{
	import br.com.chapecosolucoes.trafegusweb.client.ws.TrafegusWS;
	
	public class LoginController
	{
		public function LoginController()
		{
		}
		protected function button1_clickHandler(event:MouseEvent):void
		{
			TrafegusWS.getIntance().solicitaAcesso("ADMINISTRADOR", "ROOT_CHP");
		}
	}
}