package br.com.chapecosolucoes.trafegusweb.client.controller
{
	import br.com.chapecosolucoes.trafegusweb.client.enum.VehicleEnum;
	import br.com.chapecosolucoes.trafegusweb.client.events.PaginableEvent;
	import br.com.chapecosolucoes.trafegusweb.client.events.VehiclesEvent;
	import br.com.chapecosolucoes.trafegusweb.client.model.MainModel;
	import br.com.chapecosolucoes.trafegusweb.client.view.AbstractView;
	import br.com.chapecosolucoes.trafegusweb.client.vo.PosicaoVeiculoVO;
	
	import flash.events.MouseEvent;

	public class AbstractController
	{
		public function AbstractController()
		{
		}
		public var view:AbstractView;
		public function veiculoSelecionadoHandler(event:MouseEvent):void
		{
			if(event.currentTarget.selectedItem != null)
			{
				MainModel.getInstance().posicaoVeiculoVO = PosicaoVeiculoVO(event.currentTarget.selectedItem);
				var vehicleEvent:VehiclesEvent = new VehiclesEvent(VehiclesEvent.VEHICLE_SELECTED_EVENT,event.currentTarget.selectedIndex,VehicleEnum.DETAILS,true);
				this.view.dispatchEvent(vehicleEvent);
			}
		}
		public function pageChanged(event:PaginableEvent):void
		{
			var paginableEvent:PaginableEvent = new PaginableEvent(PaginableEvent.PAGE_CHANGED,(event.paginaAtual/20)+1);
			this.view.dispatchEvent(paginableEvent);
		}
	}
}