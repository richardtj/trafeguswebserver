package br.com.chapecosolucoes.trafegusweb.client.controller
{
	import br.com.chapecosolucoes.trafegusweb.client.components.mypopupmanager.MyPopUpManager;
	import br.com.chapecosolucoes.trafegusweb.client.components.zoom.controller.BaseZoomController;
	import br.com.chapecosolucoes.trafegusweb.client.events.DistanciaEntreReferenciasSelecionadaEvent;
	import br.com.chapecosolucoes.trafegusweb.client.events.LimparDistanciasEvent;
	import br.com.chapecosolucoes.trafegusweb.client.model.MainModel;
	import br.com.chapecosolucoes.trafegusweb.client.view.DistanciaEntreReferenciasView;
	import br.com.chapecosolucoes.trafegusweb.client.vo.DistanciaDeAteReferenciasVO;
	import br.com.chapecosolucoes.trafegusweb.client.vo.DistanciaDeAteVO;
	import br.com.chapecosolucoes.trafegusweb.client.vo.ReferenciaVO;
	
	import flash.display.DisplayObject;
	
	import mx.collections.ArrayCollection;
	import mx.core.FlexGlobals;
	import mx.events.ListEvent;
	
	import org.osmf.proxies.ListenerProxyElement;
	
	public class DistanciaDeAteReferenciasController extends BaseZoomController
	{
		public function DistanciaDeAteReferenciasController()
		{
			super();
		}
		public function adicionar():void
		{
			var distanciaEntreReferencias:DistanciaEntreReferenciasView = new DistanciaEntreReferenciasView();
			distanciaEntreReferencias.addEventListener(DistanciaEntreReferenciasSelecionadaEvent.DISTANCIA_ENTRE_REFERENCIAS_ADICIONADA_EVENT,distanciaEntreReferenciasAdicionadaEventHandler);
			MyPopUpManager.addPopUp(distanciaEntreReferencias,DisplayObject(FlexGlobals.topLevelApplication));
			MyPopUpManager.centerPopUp(distanciaEntreReferencias);
		}
		private function distanciaEntreReferenciasAdicionadaEventHandler(event:DistanciaEntreReferenciasSelecionadaEvent):void
		{
			this.view.dispatchEvent(event.clone());
		}
		public function remover():void
		{
			var event:LimparDistanciasEvent = new LimparDistanciasEvent(LimparDistanciasEvent.LIMPAR_DISTANCIAS_EVENT,new ArrayCollection(this.view.grid.selectedItems));
			this.view.dispatchEvent(event);
		}
		public function distanciaEntreReferenciasFilterFunction(item:Object):Boolean
		{
			return (String(ReferenciaVO(DistanciaDeAteReferenciasVO(item).ate).refeDescricao).toUpperCase().search(MainModel.getInstance().zoomFilter.toUpperCase()) >= 0) ||
				(String(ReferenciaVO(DistanciaDeAteReferenciasVO(item).ate).descricao).toUpperCase().search(MainModel.getInstance().zoomFilter.toUpperCase()) >= 0) ||
				(String(ReferenciaVO(DistanciaDeAteReferenciasVO(item).de).refeDescricao).toUpperCase().search(MainModel.getInstance().zoomFilter.toUpperCase()) >= 0) ||
				(String(ReferenciaVO(DistanciaDeAteReferenciasVO(item).de).descricao).toUpperCase().search(MainModel.getInstance().zoomFilter.toUpperCase()) >= 0) ||
				(String(DistanciaDeAteVO(item).distanciaDeAte()).toUpperCase().search(MainModel.getInstance().zoomFilter.toUpperCase()) >= 0);
		}
		public function itemClickEventHandler(event:ListEvent):void
		{
			var distanciaEntreReferenciasSelecionadaEvent:DistanciaEntreReferenciasSelecionadaEvent = new DistanciaEntreReferenciasSelecionadaEvent(DistanciaEntreReferenciasSelecionadaEvent.DISTANCIA_ENTRE_REFERENCIAS_SELECIONADA_EVENT,DistanciaDeAteReferenciasVO(event.itemRenderer.data));
			this.view.dispatchEvent(distanciaEntreReferenciasSelecionadaEvent);
		}
	}
}