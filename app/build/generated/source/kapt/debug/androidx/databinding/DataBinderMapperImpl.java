package androidx.databinding;

public class DataBinderMapperImpl extends MergedDataBinderMapper {
  DataBinderMapperImpl() {
    addMapper(new com.anime.oc.characters.avatar.DataBinderMapperImpl());
  }
}
