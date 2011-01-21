package br.com.chapecosolucoes.trafegusweb.client.controller
{
	import br.com.chapecosolucoes.trafegusweb.client.components.zoom.controller.BaseZoomController;
	import br.com.chapecosolucoes.trafegusweb.client.enum.LimparDistanciasEnum;
	import br.com.chapecosolucoes.trafegusweb.client.events.LimparDistanciasEvent;
	import br.com.chapecosolucoes.trafegusweb.client.model.LimparDistanciasModel;
	
	import flash.events.Event;
	
	import mx.controls.Alert;
	import mx.events.ItemClickEvent;
	import mx.events.ListEvent;
	
	public class LimparDistanciasController extends BaseZoomController
	{
		public function LimparDistanciasController()
		{
			super();
		}
		public var model:LimparDistanciasModel;
		public function limpar():void
		{
			/*var event:LimparDistanciasEvent = new LimparDistanciasEvent(LimparDistanciasEvent.LIMPAR_DISTANCIAS_EVENT,this.model.limparDistanciasVO);
			this.view.dispatchEvent(event);
			this.closeHandler();*/
		}
		public function distanciaEntreVeiculoEReferencia(event:ItemClickEvent):void
		{
			if(event.currentTarget.selectedValue == LimparDistanciasEnum.TODAS)
			{
				this.model.limparDistanciasVO.veiculoEReferencia = LimparDistanciasEnum.TODAS;
			}
			else if(event.currentTarget.selectedValue == LimparDistanciasEnum.ULTIMA)
			{
				this.model.limparDistanciasVO.veiculoEReferencia = LimparDistanciasEnum.ULTIMA;
			}
			else
			{
				this.model.limparDistanciasVO.veiculoEReferencia = LimparDistanciasEnum.NENHUMA;
			}
		}
		public function distanciaEntreReferencias(event:ItemClickEvent):void
		{
			if(event.currentTarget.selectedValue == LimparDistanciasEnum.TODAS)
			{
				this.model.limparDistanciasVO.referencias = LimparDistanciasEnum.TODAS;
			}
			else if(event.currentTarget.selectedValue == LimparDistanciasEnum.ULTIMA)
			{
				this.model.limparDistanciasVO.referencias = LimparDistanciasEnum.ULTIMA;
			}
			else
			{
				this.model.limparDistanciasVO.referencias = LimparDistanciasEnum.NENHUMA;
			}
		}
		public function distanciaEntreVeiculos(event:ItemClickEvent):void
		{
			if(event.currentTarget.selectedValue == LimparDistanciasEnum.TODAS)
			{
				this.model.limparDistanciasVO.veiculos = LimparDistanciasEnum.TODAS;
			}
			else if(event.currentTarget.selectedValue == LimparDistanciasEnum.ULTIMA)
			{
				this.model.limparDistanciasVO.veiculos = LimparDistanciasEnum.ULTIMA;
			}
			else
			{
				this.model.limparDistanciasVO.veiculos = LimparDistanciasEnum.NENHUMA;
			}
		}
	}
}