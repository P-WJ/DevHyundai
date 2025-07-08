const express = require("express"); // express 모듈 가져오기
const app = express(); // app 객체 생성
const port = 3000;

// JSON 바디 파싱을 위한 미들웨어
app.use(express.json());

// Sequelize ORM 연결
const { Sequelize } = require("sequelize");
const MemberModel = require("./models/member");

const sequelize = new Sequelize("node_memberdb", "root", "1234", {
  host: "localhost",
  dialect: "mysql",
});

const Member = MemberModel(sequelize, Sequelize.DataTypes);

// 테이블 동기화
sequelize
  .sync({ force: false }) // force: true → 테이블 DROP 후 재생성됨
  .then(() => console.log("✅ DB 연결 및 테이블 동기화 완료!"))
  .catch((err) => console.error("❌ DB 연결 실패:", err));

// GET: 회원 목록 조회
app.get("/members", async (req, res) => {
  const members = await Member.findAll();
  res.json(members);
});

// POST: 회원 등록
app.post("/members", async (req, res) => {
  try {
    const newMember = await Member.create(req.body);
    req.status(201).json(newMember);
  } catch (error) {
    res.status(400).json({ error: error.message });
  }
});

// 서버 실행
app.listen(port, () => {
  console.log(`Server running at http://localhost:${port}`);
});
