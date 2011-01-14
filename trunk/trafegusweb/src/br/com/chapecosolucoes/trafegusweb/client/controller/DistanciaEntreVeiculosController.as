package br.com.chapecosolucoes.trafegusweb.client.controller
{
	import br.com.chapecosolucoes.trafegusweb.client.view.DistanciaEntreVeiculosView;
	
	import mx.managers.PopUpManager;

	public class DistanciaEntreVeiculosController
	{
		public function DistanciaEntreVeiculosController()
		{
		}
		public var view:DistanciaEntreVeiculosView;
		public function closeHandler():void
		{
			PopUpManager.removePopUp(this.view);			
		}
		public function veiculoZoomDispatcher():void
		{
			
		}
		public function veiculosSelecionados():void
		{
			
		}
	}
}