module.exports = (sequelize, DataTypes) => {
  return sequelize.define(
    "Member",
    {
      userId: {
        type: DataTypes.STRING,
        allowNull: false,
      },
      pwd: {
        type: DataTypes.STRING,
        allowNull: false,
      },
      name: {
        type: DataTypes.STRING,
        allowNull: false,
      },
      email: {
        type: DataTypes.STRING,
        allowNull: false,
      },
      join: {
        type: DataTypes.DATE,
        defaultValue: DataTypes.NOW,
      },
    },
    {
      tableName: "members",
      timestamps: false,
    }
  );
};
