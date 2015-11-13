package com.cy;

import java.util.List;

public class CodeGenerator extends IGetContent{
    private List<WidgetInfo> listWeidget;
    
    public CodeGenerator(List<WidgetInfo> list) {
        this.listWeidget = list;
    }

    public String getContent2(){
        
        StringBuilder sbContent=new StringBuilder();
        StringBuilder sbContent_level_10_declare=new StringBuilder();
        StringBuilder sbContent_level_20_findview=new StringBuilder();
        StringBuilder sbContent_level_30_setListener=new StringBuilder();
        StringBuilder sbContent_level_40_onClickListener=new StringBuilder();
        
        for(WidgetInfo widget:listWeidget){
            
            String level_10=getContent_level_10_declare(widget);
            String level_20=getContent_level_20_findView(widget);
            String level_30=getContent_level_30_setListener(widget);
            String level_40=getContent_level_40_OnClickListener(widget);
            
            sbContent_level_10_declare.append(level_10);
            sbContent_level_20_findview.append(level_20);
            sbContent_level_30_setListener.append(level_30!=null?level_30:"");
            sbContent_level_40_onClickListener.append(level_40!=null?level_40:"");
        }
        
        sbContent.append(sbContent_level_10_declare)
        .append("\n\n")
        .append(sbContent_level_20_findview)
        .append("\n\n")
        .append(sbContent_level_30_setListener)
        .append("\n\n")
        .append(" OnClickListener mOnClickListener = new OnClickListener() {"
                + "\n   public void onClick(View v) {"
                + "\n        switch (v.getId()) {")
        .append(sbContent_level_40_onClickListener)
        .append("\n    }"
              + "\n  }"
              + "\n};");
        
        return sbContent.toString();
    }

    @Override
    String getContent_level_10_declare(WidgetInfo widget) {
        String name=widget.getIdName();
        String type=widget.getType();
        String str = " private " + type + " " + name + ";\n";
        return str;
    }

    @Override
    String getContent_level_20_findView(WidgetInfo widget) {
        String name=widget.getIdName();
        String type=widget.getType();
        String str = " " + name + " = (" + type + ")findViewById(R.id." + name + ");\n";
        return str;
    }

    @Override
    String getContent_level_30_setListener(WidgetInfo widget) {
        String name=widget.getIdName();
        String type=widget.getType();
        String str=null;
        if (type.equals("Button")) {
            str = " " + name + ".setOnClickListener(mOnClickListener);\n";
        }
        return str;
    }

    @Override
    String getContent_level_40_OnClickListener(WidgetInfo widget) {
        String name=widget.getIdName();
        String type=widget.getType();
        String str=null;
        if (type.equals("Button")) {

            str = "\n        case R.id." + name + ":\n        break;";
        }
        return str;
    }
}
