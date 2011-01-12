package br.com.chapecosolucoes.trafegusweb.client.utils
{
    import flash.display.DisplayObject;
    import flash.display.DisplayObjectContainer;
    
    import mx.containers.TitleWindow;
    import mx.controls.DataGrid;
    import mx.controls.dataGridClasses.DataGridColumn;
    import mx.utils.ObjectUtil;
    
    import org.flexunit.internals.namespaces.classInternal;

    public class Reflection
    {
        public function Reflection()
        {
        }


        public static function getObjectProperty(obj:Object, propName:String):*
        {
            var result:* = null;
            if (objectHasProperty(obj, propName))
            {
                result = obj[propName];
            }
        }

        public static function setObjectProperty(obj:Object, propName:String, value:*, validateProperty:Boolean = true):void
        {
            if (validateProperty == true)
            {
                if (objectHasProperty(obj, propName))
                {
                    obj[propName] = value;
                }
            }
            else
            {
                obj[propName] = value;
            }
        }

        public static function objectHasProperty(obj:Object, propName:String):Boolean
        {
            var propriedades:Object = ObjectUtil.getClassInfo(obj);
            for each (var prop:Object in propriedades.properties)
            {
                if (prop.toString().toLowerCase() == propName.toLowerCase())
                {
                    return true;
                }
            }
            return false;
        }

        public static function getAllObjectProperties(obj:Object):Array
        {
            var result:Array = new Array();
            var propriedades:Object = ObjectUtil.getClassInfo(obj);
            for each (var prop:Object in propriedades.properties)
                result.push(prop.toString());
            return result;
        }

        public static function copyObjectToObject(objFrom:Object, objTo:Object):void
        {
            var prop:Array = getAllObjectProperties(objFrom);
            for each (var nameProp:String in prop)
            {
                setObjectProperty(objTo, nameProp, objFrom[nameProp]);
            }
        }

        public static function getContainerWindow(container:DisplayObjectContainer):Object
        {
            var ob:DisplayObjectContainer = container;
            while (ob != null)
            {
                if (ob is TitleWindow)
                {
                    return ob;
                }
                ob = ob.parent;
            }
            return ob;
        }

        public static function getColumnIndex(grid:DataGrid, columnName:String):int
        {
            for (var i:int = 0; i < grid.columnCount; i++)
            {
                if (DataGridColumn(grid.columns[i]).dataField == columnName)
                    return i
            }
            return -1;
        }
    }
}