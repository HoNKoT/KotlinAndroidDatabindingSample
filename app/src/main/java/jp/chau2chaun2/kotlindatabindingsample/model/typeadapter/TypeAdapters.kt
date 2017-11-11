package jp.chau2chaun2.kotlindatabindingsample.model.typeadapter

import com.github.gfx.android.orma.annotation.StaticTypeAdapter
import com.github.gfx.android.orma.annotation.StaticTypeAdapters
import jp.chau2chaun2.kotlindatabindingsample.model.Gender

@StaticTypeAdapters(
        StaticTypeAdapter(
                targetType = Gender::class,
                serializedType = String::class,
                serializer = "serializeGender",
                deserializer = "deserializeGender")
)
class TypeAdapters {
    companion object {
        @JvmStatic
        fun serializeGender(gender: Gender): String = gender.name

        @JvmStatic
        fun deserializeGender(serialized: String): Gender = Gender.valueOf(serialized)
    }
}
