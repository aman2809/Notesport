package com.example.notesport;

public class StreamDataModel
{
    String Stream_Description,Stream_Icon,Stream_Name;

    public StreamDataModel()
    {

    }

    public StreamDataModel(String stream_Description, String stream_Icon, String stream_Name) {
        Stream_Description = stream_Description;
        Stream_Icon = stream_Icon;
        Stream_Name = stream_Name;
    }

    public String getStream_Description() {
        return Stream_Description;
    }

    public void setStream_Description(String stream_Description) {
        Stream_Description = stream_Description;
    }

    public String getStream_Icon() {
        return Stream_Icon;
    }

    public void setStream_Icon(String stream_Icon) {
        Stream_Icon = stream_Icon;
    }

    public String getStream_Name() {
        return Stream_Name;
    }

    public void setStream_Name(String stream_Name) {
        Stream_Name = stream_Name;
    }
}