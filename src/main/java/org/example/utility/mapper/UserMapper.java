package org.example.utility.mapper;

import org.example.data.model.User;
import org.example.dto.CreateNewUser;
import org.example.dto.CreateNewUserResponse;
import org.example.utility.SecurePassword;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

   UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

   @Mapping(source = "password", target = "password", qualifiedByName = "hashPassword")
   User mapDTOToUser(CreateNewUser createNewUser);

   CreateNewUserResponse mapUserToResponse(String message, boolean success);

   private static String hashPassword(String password) {
      return SecurePassword.hashPassword(password);
   }

}
